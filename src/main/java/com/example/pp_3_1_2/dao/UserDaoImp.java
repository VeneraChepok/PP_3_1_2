package com.example.pp_3_1_2.dao;

import com.example.pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
       entityManager.createNativeQuery("delete from users where id=:id").setParameter("id",id).executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
