package com.springexample.SpringDataJPA1.mapper;


import com.springexample.SpringDataJPA1.model.dto.FlightDTO;
import com.springexample.SpringDataJPA1.model.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    public static FlightDTO toFlightDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new FlightDTO(
                flight.getId(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getAirline(),
                flight.getFlightNumber(),
                flight.getDepartureDate(),
                flight.getArrivalDate(),
                flight.getFlightStatus()
        );
    }

    public static Flight toFlightEntity(FlightDTO flightDTO) {
        if (flightDTO == null) {
            return null;
        }
        return new Flight(
                flightDTO.getId(),
                flightDTO.getOrigin(),
                flightDTO.getDestination(),
                flightDTO.getAirline(),
                flightDTO.getFlightNumber(),
                flightDTO.getDepartureDate(),
                flightDTO.getArrivalDate(),
                flightDTO.getFlightStatus(),
                null
        );
    }

    public static void updateEntity(Flight flight, FlightDTO flightDTO) {
        if (flightDTO == null || flight == null) {
            return;
        }
        flight.setOrigin(flightDTO.getOrigin());
        flight.setDestination(flightDTO.getDestination());
        flight.setAirline(flightDTO.getAirline());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setArrivalDate(flightDTO.getArrivalDate());
        flight.setFlightStatus(flightDTO.getFlightStatus());
    }

}
