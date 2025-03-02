package com.springexample.SpringDataJPA1.model.dto;

import com.springexample.SpringDataJPA1.model.enums.FlightStatus;

import java.util.Date;

public class FlightDTO {

    private Long id;
    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private FlightStatus flightStatus;

    public FlightDTO() {}

    public FlightDTO(Long id, String origin, String destination, String airline, String flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightStatus = flightStatus;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }
}
