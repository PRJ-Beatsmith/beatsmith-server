package app.beatsmith.dao.service.impl;

import app.beatsmith.dao.UserDAO;
import app.beatsmith.dao.service.UserDAOService;
import app.beatsmith.entity.db.UserEntity;
import app.beatsmith.entity.form.user.CheckUsernameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOServiceImpl implements UserDAOService {
    private final UserDAO userDAO;

    public UserDAOServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean isUsernameAvailable(CheckUsernameForm checkUsernameForm) {
        final String username = checkUsernameForm.getUsername();
        return userDAO.existsByUsername(username);
    }

    @Override
    public void saveUser(UserEntity userEntity) {

    }
}
