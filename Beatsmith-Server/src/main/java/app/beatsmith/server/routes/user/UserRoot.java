package app.beatsmith.server.routes.user;

import app.beatsmith.entity.form.user.CheckUsernameForm;
import app.beatsmith.entity.form.user.SignUpForm;
import app.beatsmith.entity.response.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "User Pfad", description = "Dieser Pfad stellt die API für User dar.")
public interface UserRoot {
    @PostMapping("/checkusername")
    public ResponseEntity<HttpStatus> usernameAvailable(CheckUsernameForm checkUsernameForm);

    @PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<BaseResponse> singUp(@Valid SignUpForm signUpForm, BindingResult bindingResult, HttpServletRequest request);

}
