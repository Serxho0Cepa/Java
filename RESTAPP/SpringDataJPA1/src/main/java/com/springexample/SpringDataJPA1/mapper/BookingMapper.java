package com.springexample.SpringDataJPA1.mapper;

import com.springexample.SpringDataJPA1.model.dto.BookingDTO;
import com.springexample.SpringDataJPA1.model.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public static BookingDTO toBookingDTO(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getBookingDate(),
                booking.getBookingStatus(),
                booking.getUser().getId(),
                booking.getFlight().getId()
        );
    }

    public static Booking toBookingEntity(BookingDTO dto) {
        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setBookingStatus(dto.getBookingStatus());
        return booking;
    }
}
