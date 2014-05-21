package ua.org.gostroy.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by panser on 5/21/14.
 */
@Repository
public class UserJPA implements UserDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    public User find(Long id) {
        log.trace("find ...");
        User user = em.find(User.class, id);
        log.trace("find.");
        return user;
    }

    @Override
    public List<User> findAll() {
        log.trace("findAll ...");
        Query query = em.createQuery("SELECT e FROM User e");
        List<User> users =  (List<User>) query.getResultList();
        log.trace("findAll.");
        return users;
    }

    @Override
    public Long save(User user) {
        log.trace("save ...");
        em.merge(user);
        log.trace("save.");
        return user.getId();
    }

    @Override
    public void update(User user) {
        log.trace("update ...");
        em.merge(user);
        log.trace("update.");
    }
}
