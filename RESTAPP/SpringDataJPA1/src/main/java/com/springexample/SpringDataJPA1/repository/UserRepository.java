package com.springexample.SpringDataJPA1.repository;

import com.springexample.SpringDataJPA1.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findAll();

    Optional<User> findById(Long id);

    @Query("SELECT DISTINCT u FROM User u INNER JOIN u.bookings b WHERE b.flight.id = :flightId")
    List<User> findUsersByFlightId(@Param("flightId") Long flightId);

//    Optional<User> save(User user);

    void deleteById(Long id);
}
