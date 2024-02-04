package app.beatsmith.server.routes.user;

import app.beatsmith.dao.UserDAO;
import app.beatsmith.entity.form.UserForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRootController {

    @Autowired
    private UserDAO userDao;
    @GetMapping
    public String getRoot() {
        return "403";
    }

    @PostMapping("/checkusername")
    public ResponseEntity<HttpStatus> usernameAvailable(String username) {
        boolean isTaken = userDao.existsByUsername(username);
        if (isTaken) {
            ResponseEntity<HttpStatus> badRequest = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return badRequest;
        }
        ResponseEntity<HttpStatus> ok = new ResponseEntity<HttpStatus>(HttpStatus.OK);
        return ok;
    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> singUp(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResponseEntity<HttpStatus> badRequest = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return badRequest;
        }
        System.out.println(userForm.getUsername());
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_EXTENDED);
    }
}
