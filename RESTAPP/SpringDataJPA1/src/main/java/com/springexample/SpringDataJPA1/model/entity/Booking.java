package com.springexample.SpringDataJPA1.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springexample.SpringDataJPA1.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "booking", uniqueConstraints = {
        @UniqueConstraint(name = "unique_booking_code_constraint", columnNames = {"booking_date"})
})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "booking_date", unique = true, nullable = false)
    private Date bookingDate;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Flight flight;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    public Booking() {
    }

    public Booking(Long id, Date bookingDate, BookingStatus bookingStatus, User user, Flight flight) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.flight = flight;
    }

    public Booking(Date bookingDate, BookingStatus bookingStatus, User user, Flight flight) {
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.flight = flight;
    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingdate) { this.bookingDate = bookingdate; }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
