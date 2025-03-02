package com.springexample.SpringDataJPA1.controller;



import com.springexample.SpringDataJPA1.model.dto.BookingDTO;
import com.springexample.SpringDataJPA1.repository.BookingRepository;
import com.springexample.SpringDataJPA1.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    private BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping(path = "/{userId}/{bookingId}", produces = "application/json")
    public ResponseEntity<BookingDTO> getBookingByUserIdAndBookingId(@PathVariable Long userId, @PathVariable Long bookingId) {
        return bookingService.getBookingByUserIdAndBookingId(userId, bookingId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/{userId}", produces = "application/json")
    public ResponseEntity<List<BookingDTO>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookings = bookingService.getBookingsByUserId(userId);
        return bookings.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(bookings);
    }

    @GetMapping(path = "/flight/{flightId}", produces = "application/json")
    public ResponseEntity<List<BookingDTO>> getBookingsByFlightId(@PathVariable Long flightId) {
        List<BookingDTO> bookings = bookingService.getBookingsByFlightId(flightId);
        return bookings.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(bookings);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookingDTO> createOrUpdateBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createOrUpdateBooking(bookingDTO.getUserId(), bookingDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
