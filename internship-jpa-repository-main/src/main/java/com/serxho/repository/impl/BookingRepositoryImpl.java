package com.serxho.repository.impl;

import com.serxho.configuration.EntityManagerConfiguration;
import com.serxho.model.entity.Booking;
import com.serxho.model.entity.UserDetails;
import com.serxho.repository.BookingRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {
    private EntityManager entityManager;
    public BookingRepositoryImpl() { entityManager = EntityManagerConfiguration.getEntityManager(); }

    @Override
    public Optional<Booking> findById(Long aLong) {
        return Optional.ofNullable(entityManager.find(Booking.class, aLong));
    }

    public List<Booking> findByUserusername(String username) {
        List<Booking> bookings = entityManager.createQuery("SELECT b FROM Booking b inner join User u on b.id = u.id WHERE u.username = :uname", Booking.class)
                .setParameter("uname", username)
                .getResultList();
        return bookings;
    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    public List<UserDetails> findFromNativeQuery(String status) {
        List<UserDetails> details = entityManager.createNativeQuery("SELECT * FROM User_Details as b where b.phone_Number = :numberr", Booking.class)
                .setParameter("numberr", "1234")
                .getResultList();
        return details;

    }

    @Override
    public void save(Booking booking) {
        entityManager.getTransaction().begin();
        if (booking.getId() != null) {
            findById(Long.valueOf(booking.getId())).ifPresent(existingBooking -> {
                booking.setBookingStatus(booking.getBookingStatus());
                booking.setBookingDate(booking.getBookingDate());
            });
        } else {
            entityManager.persist(booking);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Booking booking) {
    }

}
