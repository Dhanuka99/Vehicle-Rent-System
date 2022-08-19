package lk.dmax.spring.service.impl;


import lk.dmax.spring.dto.BookingDTO;
import lk.dmax.spring.dto.CustomerDTO;
import lk.dmax.spring.entity.Booking;
import lk.dmax.spring.entity.Customer;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.exception.ValidateException;
import lk.dmax.spring.repo.BookingRepo;
import lk.dmax.spring.repo.CustomerRepo;
import lk.dmax.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BookingRepo  bookingRepo;


    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
            if (customerRepo.existsById(dto.getCustomerNic())) {
                throw new ValidateException("Customer Already Exist");
            }
            customerRepo.save(mapper.map(dto, Customer.class));
        }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(customerRepo.existsById(dto.getCustomerNic())){
           customerRepo.save(mapper.map(dto,Customer.class));
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)){
            throw new NotFoundException("No Customer For Delete");
        }customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            return mapper.map(customer,CustomerDTO.class);
        }return null;

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {

        List<Customer> allCustomers = customerRepo.findAll();
        return mapper.map(allCustomers,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public void placeBooking(BookingDTO bookingDTO) {
        bookingRepo.save(mapper.map(bookingDTO, Booking.class));

    }
}
