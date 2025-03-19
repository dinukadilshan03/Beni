package com.Beni.Backend.booking_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    private String clientName;
    private LocalDateTime bookingDate;
    private LocalDateTime rescheduledDate;
    private boolean isCancelled;

    public Booking(String clientName, LocalDateTime bookingDate) {
        this.clientName = clientName;
        this.bookingDate = bookingDate;
        this.isCancelled = false;
    }
}
