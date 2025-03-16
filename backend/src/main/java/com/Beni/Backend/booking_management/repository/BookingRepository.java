package com.Beni.Backend.booking_management.repository;

import com.Beni.Backend.booking_management.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
