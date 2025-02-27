package com.serxho.repository;

import com.serxho.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findAllNamedQuery(String username);

    Optional<User> findById(Long id);

}
