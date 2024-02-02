package app.beatsmith.server.routes;

import app.beatsmith.entity.db.User;
import app.beatsmith.servicer.MavenReaderService;
import app.beatsmith.servicer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

    @Autowired
    private MavenReaderService mavenReaderService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getRoot() {
        User user = new User();
        user.setUsername("AAA");
        user.setEmail("aaa");
        user.setFullname("lll");


        try {
            userService.save(user);
        } catch (Exception e) {
            int i = 0;
        }
        System.out.println(mavenReaderService.getVersion());
        return "404";
    }
}
