package lk.dmax.spring.service;

import lk.dmax.spring.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {

    void saveBooking(BookingDTO bookingDTO);

    void updateBooking(BookingDTO bookingDTO);

    ArrayList<BookingDTO> getAllBookings();

    BookingDTO searchBooking(int id);

    void deleteBooking(String id);
}
