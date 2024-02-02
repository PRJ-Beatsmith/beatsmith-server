package app.beatsmith.servicer;

import app.beatsmith.entity.db.User;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

public interface UserService {
    /**
     * Saves the given {@link User}.
     *
     * @param user {@link User}
     * @return {@link User}
     */
    User save(User user) throws SQLIntegrityConstraintViolationException;

    /**
     * Returns {@link User} of the given {@link UUID}.
     *
     * @param uuid {@link UUID}
     * @return {@link User}
     */
    User findByUUID(UUID uuid);
}
