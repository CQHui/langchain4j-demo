package com.qihui.langchain4jdemo.booking;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String bookingNumber) {
        super("Booking " + bookingNumber + " not found");
    }
}
