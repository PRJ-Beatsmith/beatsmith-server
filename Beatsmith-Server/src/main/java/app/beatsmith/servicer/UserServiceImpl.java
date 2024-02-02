package app.beatsmith.servicer;

import app.beatsmith.entity.db.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserServiceImpl implements UserService {
    /** Stellt Datenbankverbindung dar. */

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Diese Methode speichert einen {@link User} in der Datenbank.
     *
     * @param user {@link User}
     * @return {@link User}
     */
    @Override
    @Transactional
    public User save(User user) throws
            EntityExistsException, IllegalArgumentException, TransactionRequiredException {

        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    /**
     * Gibt ein {@link User} anhand seiner Id aus der Datenbank aus.
     * Falls kein {@link User} unter der gegebene Id gefinden werden kann wird <code>null</code> ausgegeben.
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {

        TypedQuery<User> query = entityManager.createQuery("select a from user_tbl a where a.id = ?1", User.class);
        query.setParameter(1, id);

        return query.getSingleResult();
    }
}
