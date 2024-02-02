package app.beatsmith.servicer;

import app.beatsmith.entity.db.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public User findByUUID(UUID customer) {

        TypedQuery<User> query = entityManager.createQuery("select a from user_tbl a where a.id = ?1", User.class);
        query.setParameter(1, customer);

        return query.getSingleResult();
    }
}
