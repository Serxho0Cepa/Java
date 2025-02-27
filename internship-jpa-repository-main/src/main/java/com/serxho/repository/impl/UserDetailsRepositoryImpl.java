package com.serxho.repository.impl;

import com.serxho.configuration.EntityManagerConfiguration;
import com.serxho.model.entity.UserDetails;
import com.serxho.repository.UserDetailsRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private final EntityManager entityManager;
    public UserDetailsRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<UserDetails> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<UserDetails> findAll() {
        return null;
    }

    @Override
    public void save(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(UserDetails userDetails) {
    }

}
