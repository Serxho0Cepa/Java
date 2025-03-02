package com.springexample.SpringDataJPA1.model.dto;

import com.springexample.SpringDataJPA1.model.enums.BookingStatus;

import java.util.Date;

public class BookingDTO {

    private Long id;
    private Date bookingDate;
    private BookingStatus bookingStatus;
    private Long userId;
    private Long flightId;

    public BookingDTO() {
    }

    public BookingDTO(Long id, Date bookingDate, BookingStatus bookingStatus, Long userId, Long flightId) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.userId = userId;
        this.flightId = flightId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
