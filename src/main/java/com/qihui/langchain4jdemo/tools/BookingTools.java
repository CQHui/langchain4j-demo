package com.qihui.langchain4jdemo.tools;

import com.qihui.langchain4jdemo.booking.Booking;
import com.qihui.langchain4jdemo.booking.BookingService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * 目前测试，似乎Tool和千问模型不兼容，调用会报错
 */
@Component
public class BookingTools {
    private final Logger log = Logger.getLogger(BookingTools.class.getName());
    private final BookingService bookingService;

    public BookingTools(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Tool("""
          获取存在的订单内容
          内容有预定号，预定的开始时间和结束时间以及用户信息
          """)
    public Booking getBookingDetails(@P("预定号") String bookingNumber,
                                     @P("用户姓名") String customerName) {
        Booking bookingDetails = bookingService.getBookingDetails(bookingNumber, customerName);
        log.info("===========getBookingDetails: " + bookingDetails);
        return bookingDetails;
    }

    @Tool("""
          取消存在的订单内容
          """)
    public void cancelBooking(@P("预定号") String bookingNumber,
                              @P("用户姓名") String customerName) {
        bookingService.cancelBooking(bookingNumber, customerName);
        log.info("=======cancelBooking: " + bookingNumber);
    }
}
