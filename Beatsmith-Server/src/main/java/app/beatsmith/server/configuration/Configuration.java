package app.beatsmith.server.configuration;

import app.beatsmith.dao.UserDAO;
import app.beatsmith.dao.service.UserDAOService;
import app.beatsmith.dao.service.impl.UserDAOServiceImpl;
import app.beatsmith.servicer.MavenReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private UserDAO userDAO;

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
        UserDAOService userServiceDAO = new UserDAOServiceImpl(userDAO);
        return userServiceDAO;
    }

}
