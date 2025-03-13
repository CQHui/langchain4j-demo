package com.qihui.langchain4jdemo.booking;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookingService {
    private static final Customer CUSTOMER = new Customer("John");

    private static final String BOOKING_NUMBER = "MS-777";
    private static final Booking BOOKING = new Booking(
            BOOKING_NUMBER,
            LocalDate.of(2025, 12, 13),
            LocalDate.of(2025, 12, 31),
            CUSTOMER
    );

    private static final Map<String, Booking> BOOKINGS = new HashMap<>() {{
        put(BOOKING_NUMBER, BOOKING);
    }};

    public Booking getBookingDetails(String bookingNumber, String customerName) {
        ensureExists(bookingNumber, customerName);

        // Imitating DB lookup
        return BOOKINGS.get(bookingNumber);
    }

    public void cancelBooking(String bookingNumber, String customerName) {
        ensureExists(bookingNumber, customerName);

        // Imitating booking cancellation
        BOOKINGS.remove(bookingNumber);
    }

    private void ensureExists(String bookingNumber, String customerName) {
        // Imitating DB lookup

        Booking booking = BOOKINGS.get(bookingNumber);
        if (booking == null) {
            throw new BookingNotFoundException(bookingNumber);
        }

        Customer customer = booking.customer();
        if (!customer.name().equals(customerName)) {
            throw new BookingNotFoundException(bookingNumber);
        }
    }
}
