package app.beatsmith.server.routes.user;

import app.beatsmith.dao.service.UserDAOService;
import app.beatsmith.entity.db.UserEntity;
import app.beatsmith.entity.form.user.CheckUsernameForm;
import app.beatsmith.entity.form.user.SignUpForm;
import app.beatsmith.entity.response.BaseResponse;
import app.beatsmith.entity.response.error.ErrorResponse;
import app.beatsmith.entity.response.error.FormErrorResponse;
import app.beatsmith.entity.response.success.OkResponse;
import app.beatsmith.utils.DBDataTransformer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserRootController implements UserRoot{
    private static final Logger LOG = LoggerFactory.getLogger(UserRootController.class);

    @Autowired
    private UserDAOService userDAOService;

    @Override
    @Secured("ROLE_ANONYMOUS")
    public ResponseEntity<HttpStatus> usernameAvailable(CheckUsernameForm checkUsernameForm) {
        boolean isTaken = userDAOService.isUsernameAvailable(checkUsernameForm);
        if (isTaken) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> singUp(@Valid SignUpForm signUpForm, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if (bindingResult.hasErrors()) {
                final FormErrorResponse formErrorResponse = new FormErrorResponse(bindingResult);
                return new ResponseEntity<>(formErrorResponse, HttpStatus.BAD_REQUEST);
            }

            final UserEntity userEntity = DBDataTransformer.signUpFormToUserEntity(signUpForm);
            // TODO: Datenbank Interface überall ändern.
            //userDao.save(userEntity);

            final OkResponse okResponse = new OkResponse();
            return new ResponseEntity<>(okResponse, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("singUp: ", e);
            final ErrorResponse errorResponse = new ErrorResponse(e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
