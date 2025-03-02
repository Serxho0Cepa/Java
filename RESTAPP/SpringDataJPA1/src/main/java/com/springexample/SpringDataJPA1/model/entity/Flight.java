package com.springexample.SpringDataJPA1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springexample.SpringDataJPA1.model.enums.FlightStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Long id;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "airline")
    private String airline;

    @Column(name = "flight_number", unique = true, nullable = false)
    private String flightNumber;

    @Column(name = "departure_date", unique = true, nullable = false)
    private Date departureDate;

    @Column(name = "arrival_date", unique = true, nullable = false)
    private Date arrivalDate;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIgnore
    private List<Booking> bookings;

//    @ManyToMany
//    @JoinTable(
//            name = "user_flight",
//            joinColumns = @JoinColumn(name = "flight_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;

    public Flight() {}

    public Flight(Long id, String origin, String destination, String airline, String flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus, List<Booking> bookings) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightStatus = flightStatus;
        this.bookings = bookings;
    }

    public Flight(String origin, String destination, String airline, String flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus, List<Booking> bookings) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightStatus = flightStatus;
        this.bookings = bookings;
    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id; }

    public String getOrigin() { return origin;}
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination;}
    public void setDestination(String destination) { this.destination = destination; }

    public String getAirline() { return airline;}
    public void setAirline(String airline) {this.airline = airline;}

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public Date getDepartureDate() { return departureDate;}
    public void setDepartureDate(Date departureDate) { this.departureDate = departureDate; }

    public Date getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(Date arrivalDate) { this.arrivalDate = arrivalDate; }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
