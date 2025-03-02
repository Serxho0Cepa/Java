package com.springexample.SpringDataJPA1.repository;

import com.springexample.SpringDataJPA1.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {

    Optional<Booking> findById(Long id);

    List<Booking> findAllByOrderByBookingDate();

    Optional<Booking> findByIdAndUserId(Long userId, Long bookingId);

    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByFlightId(Long flightId);

    Optional<Booking> findByUserIdAndFlightId(Long userId, Long flightId);

    void deleteById(Long id);

}
