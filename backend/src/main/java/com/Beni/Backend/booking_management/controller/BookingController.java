package com.Beni.Backend.booking_management.controller;

import com.Beni.Backend.booking_management.model.Booking;
import com.Beni.Backend.booking_management.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestParam String clientName,
                                                 @RequestParam String bookingDate) {
        LocalDateTime date = LocalDateTime.parse(bookingDate);
        Booking booking = bookingService.createBooking(clientName, date);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    // Get all bookings
    @GetMapping("/")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Reschedule a booking
    @PutMapping("/reschedule/{id}")
    public ResponseEntity<Booking> rescheduleBooking(@PathVariable String id,
                                                     @RequestParam String newBookingDate) {
        LocalDateTime newDate = LocalDateTime.parse(newBookingDate);
        Booking updatedBooking = bookingService.rescheduleBooking(id, newDate);
        return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
    }

    // Cancel a booking
    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable String id) {
        boolean isCancelled = bookingService.cancelBooking(id);
        return isCancelled ? ResponseEntity.ok("Booking Cancelled") : ResponseEntity.notFound().build();
    }
}
