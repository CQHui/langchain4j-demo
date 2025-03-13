package com.qihui.langchain4jdemo.booking;

import java.time.LocalDate;

public record Booking(
        String bookingNumber,
        LocalDate bookingBeginDate,
        LocalDate bookingEndDate,
        Customer customer) {
}
