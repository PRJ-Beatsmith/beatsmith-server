package app.beatsmith.servicer;

import app.beatsmith.entity.db.User;

import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {

    public User save(User user) throws SQLIntegrityConstraintViolationException;

    public User findById(String id);
}
