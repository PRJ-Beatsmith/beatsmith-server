package app.beatsmith.servicer;

import app.beatsmith.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  {
    /** Stellt Datenbankverbindung dar. */
    private final UserDAO userDAO;

    @Autowired

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
