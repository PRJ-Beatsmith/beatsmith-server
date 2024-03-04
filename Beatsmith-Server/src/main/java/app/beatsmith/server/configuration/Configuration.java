package app.beatsmith.server.configuration;

import app.beatsmith.dao.UserDAO;
import app.beatsmith.dao.service.UserDAOService;
import app.beatsmith.dao.service.impl.UserDAOServiceImpl;
import app.beatsmith.servicer.MavenReaderService;
import app.beatsmith.servicer.UserManagementService;
import com.google.firebase.auth.FirebaseAuth;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Bean
    public MavenReaderService getMavenReaderService() {
        try {
            return new MavenReaderService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public UserDAOService userDAOService() {
        return new UserDAOServiceImpl(userDAO);
    }

    @Bean
    public UserManagementService userManagementService() {
        return new UserManagementService(firebaseAuth);
    }

}
