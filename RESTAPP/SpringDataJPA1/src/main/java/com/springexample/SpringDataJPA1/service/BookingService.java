package com.springexample.SpringDataJPA1.service;


import com.springexample.SpringDataJPA1.mapper.BookingMapper;
import com.springexample.SpringDataJPA1.model.dto.BookingDTO;
import com.springexample.SpringDataJPA1.model.entity.Booking;
import com.springexample.SpringDataJPA1.model.entity.Flight;
import com.springexample.SpringDataJPA1.model.entity.User;
import com.springexample.SpringDataJPA1.repository.BookingRepository;
import com.springexample.SpringDataJPA1.repository.FlightRepository;
import com.springexample.SpringDataJPA1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAllByOrderByBookingDate()
                .stream()
                .map(BookingMapper::toBookingDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookingDTO> getBookingByUserIdAndBookingId(Long userId, Long bookingId) {
        return bookingRepository.findByIdAndUserId(userId, bookingId)
                .map(BookingMapper::toBookingDTO);
    }

    public List<BookingDTO> getBookingsByUserId(Long userId) {
        return bookingRepository.findAllByUserId(userId)
                .stream()
                .map(BookingMapper::toBookingDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByFlightId(Long flightId) {
        return bookingRepository.findAllByFlightId(flightId)
                .stream()
                .map(BookingMapper::toBookingDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO createOrUpdateBooking(Long userId, BookingDTO bookingDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Flight flight = flightRepository.findById(bookingDTO.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Booking booking = bookingRepository.findByUserIdAndFlightId(userId, bookingDTO.getFlightId())
                .orElse(new Booking());

        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setBookingStatus(bookingDTO.getBookingStatus());

        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.toBookingDTO(savedBooking);
    }


    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        bookingRepository.delete(booking);
    }
}
