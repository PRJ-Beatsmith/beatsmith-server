package app.beatsmith.server.routes;

import app.beatsmith.servicer.MavenReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class RootController {

    @Autowired
    private MavenReaderService mavenReaderService;

    @GetMapping("/")
    public String root() {


        try {
            // userRepository.save(user);
        } catch (Exception e) {
            int i = 0;
        }
        System.out.println(mavenReaderService.getVersion());
        return "404";
    }
}
