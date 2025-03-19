package com.Beni.Backend.booking_management.service;

import com.Beni.Backend.booking_management.model.Booking;
import com.Beni.Backend.booking_management.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create a new booking
    public Booking createBooking(String clientName, LocalDateTime bookingDate) {
        Booking booking = new Booking(clientName, bookingDate);
        return bookingRepository.save(booking);
    }

    // View all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // View a single booking by id
    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    // Reschedule a booking
    public Booking rescheduleBooking(String id, LocalDateTime newBookingDate) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setRescheduledDate(newBookingDate);
            return bookingRepository.save(booking);
        }
        return null;
    }

    // Cancel a booking
    public boolean cancelBooking(String id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setCancelled(true);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }
}
