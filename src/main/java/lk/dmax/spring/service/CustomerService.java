package lk.dmax.spring.service;

import lk.dmax.spring.dto.BookingDTO;
import lk.dmax.spring.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);


    void updateCustomer(CustomerDTO dto);

    void placeBooking(BookingDTO bookingDTO);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();
}
