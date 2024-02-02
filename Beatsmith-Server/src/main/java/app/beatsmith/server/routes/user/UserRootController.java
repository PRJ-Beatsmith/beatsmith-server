package app.beatsmith.server.routes.user;

import app.beatsmith.entity.form.UserForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRootController {
    @GetMapping
    public String getRoot() {
        return "403";
    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> singUp(UserForm userForm) {
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_EXTENDED);
    }
}
