package com.serxho.repository;

import com.serxho.model.entity.Booking;

import java.util.List;

public interface BookingRepository extends Repository<Booking, Long>{

    List<Booking> findByUserusername(String username);
}
