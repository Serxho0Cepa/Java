package com.serxho.repository.impl;

import com.serxho.configuration.EntityManagerConfiguration;
import com.serxho.model.entity.User;
import com.serxho.repository.UserRepository;
import com.serxho.util.Queries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;
    public UserRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> result = entityManager.createQuery(Queries.FIND_ALL_USERS, User.class);
        return result.getResultList();
    }

    public List<User> findAllNamedQuery(String username) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :uname");
        query.setParameter("uname", username);
        List<User> users = (List<User>) query.getResultList();
        TypedQuery<User> result = entityManager.createNamedQuery("findByusername", User.class);
        result.setParameter("uname", username);
        return result.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        if (user.getId() != null) {
            findById(user.getId()).ifPresent(existingUser -> {
                user.setUsername(user.getUsername());
                user.setPassword(user.getPassword());
                user.setRole(user.getRole());
            });
        } else {
            if (user.getUserDetails() != null) {     //modifikim
                user.getUserDetails().setUser(user); //modifikim
            }                                        //modifikim
            entityManager.persist(user);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(User user) {
        if (user.getId() != null) {
            entityManager.getTransaction().begin();
            findById(user.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
    }

    public Optional<User> findByUsername(String username) {
        TypedQuery<User> result = entityManager.createNamedQuery("test", User.class);
        result.setParameter("username", username);
        return Optional.ofNullable(result.getSingleResult());
    }



}
