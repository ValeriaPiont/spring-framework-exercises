package com.bobocode.dao.impl;

import com.bobocode.dao.UserDao;
import com.bobocode.model.jpa.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This class implements {@link UserDao} using JPA.
 */

@Repository("userDao")
@Transactional // wraps object with transaction proxy using Spring AOP. Is applied to all public methods of a class
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
