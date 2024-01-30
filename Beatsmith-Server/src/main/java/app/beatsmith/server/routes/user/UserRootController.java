package app.beatsmith.server.routes.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRootController {
    @GetMapping
    public String getRoot() {
        return "403";
    }
}
