package com.springexample.SpringDataJPA1.service;

import com.springexample.SpringDataJPA1.mapper.FlightMapper;
import com.springexample.SpringDataJPA1.model.dto.FlightDTO;
import com.springexample.SpringDataJPA1.model.entity.Flight;
import com.springexample.SpringDataJPA1.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll().
                stream().
                map(FlightMapper::toFlightDTO).
                toList();
    }

    public Optional<FlightDTO> getFlightById(Long id) {
        return flightRepository.findById(id).
                map(FlightMapper::toFlightDTO);
    }

    public List<FlightDTO> getFlightByOriginAndDepartureDate(String origin, Date departureDate) {
        return flightRepository.findByOriginAndDepartureDate(origin, departureDate).
                stream().
                map(FlightMapper::toFlightDTO).
                toList();
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    @Transactional
    public FlightDTO createFlight(FlightDTO flightDTO) {
        Flight flight = FlightMapper.toFlightEntity(flightDTO);
        flight = flightRepository.save(flight);
        return FlightMapper.toFlightDTO(flight);
    }

    @Transactional
    public FlightDTO updateFlight(Long flightId, FlightDTO flightDTO) {
        Flight existingFlight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + flightId));

        FlightMapper.updateEntity(existingFlight, flightDTO);
        existingFlight = flightRepository.save(existingFlight);
        return FlightMapper.toFlightDTO(existingFlight);
    }
}
