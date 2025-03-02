package com.springexample.SpringDataJPA1.repository;


import com.springexample.SpringDataJPA1.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
    Optional<Flight> findById(Long id);

    @Query("SELECT f FROM Flight f WHERE f.origin = :origin AND FUNCTION('DATE', f.departureDate) = :departureDate")
    List<Flight> findByOriginAndDepartureDate(@Param("origin") String origin, @Param("departureDate") Date departureDate);

}
