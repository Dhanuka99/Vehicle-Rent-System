package lk.dmax.spring.service.impl;


import lk.dmax.spring.dto.BookingDTO;
import lk.dmax.spring.dto.DriverDTO;
import lk.dmax.spring.dto.VehicleDTO;
import lk.dmax.spring.entity.Booking;
import lk.dmax.spring.entity.Vehicle;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.repo.BookingRepo;
import lk.dmax.spring.service.BookingService;
import lk.dmax.spring.service.DriverService;
import lk.dmax.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.jws.Oneway;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    DriverService driverService;

    @Autowired
    VehicleService vehicleService;


    @Override
    public void saveBooking(BookingDTO bookingDTO) {
//        int lastId = bookingRepo.getLastId();
//        int newId = lastId+1;
//        System.out.println("booking id is "+newId);
        if (bookingRepo.existsById(bookingDTO.getBookingId())){
            throw new NotFoundException("Booking Already Exists.");
        }
        System.out.println("1111111111111");
        String driverNic = bookingDTO.getDriverNic();
        System.out.println("2222222222");
        DriverDTO driverDTO = driverService.searchDriver(driverNic);
        System.out.println("333333333");
        int driverStatus = driverDTO.getDriverStatus();
        driverStatus=1;
        System.out.println("4444444");
       DriverDTO driverDTO2 = new DriverDTO(bookingDTO.getDriverNic(), driverDTO.getDriverLicenseNo(), driverDTO.getDriverName(), driverDTO.getDriverAddress(), driverDTO.getDriverTel(), driverStatus);
        driverService.updateDriver(driverDTO2);
        System.out.println("55555555555");

        String vehicleNo = bookingDTO.getVehicleNo();
        VehicleDTO vehicleDTO = vehicleService.searchVehicle(vehicleNo);
        int vehicleStatus = vehicleDTO.getVehicleStatus();
        vehicleStatus=1;
        VehicleDTO vehicleDTO1 = new VehicleDTO(bookingDTO.getVehicleNo(), vehicleStatus, vehicleDTO.getBrand(), vehicleDTO.getNoOfPassenger(), vehicleDTO.getTransmissionType(), vehicleDTO.getFuelType(), vehicleDTO.getPackageId());
        vehicleService.updateVehicle(vehicleDTO1);

        System.out.println("6666666666");

      BookingDTO bookingDTO1 = new BookingDTO(bookingDTO.getBookingId(),bookingDTO.getCustomerNic(), bookingDTO.getVehicleNo(), bookingDTO.getDriverNic(), bookingDTO.getBookingDate(), bookingDTO.getBookingTime(), bookingDTO.getBookingStatus(), bookingDTO.getReturnDate(), bookingDTO.getReturnTime(), bookingDTO.getStartMileage(), bookingDTO.getEndMileage(), bookingDTO.getReleaseStatus());

        bookingRepo.save(mapper.map(bookingDTO1,Booking.class));
        System.out.println("game close");
    }


    @Override
    public void updateBooking(BookingDTO bookingDTO) {

    }

    @Override
    public ArrayList<BookingDTO> getAllBookings() {
        return null;
    }

    @Override
    public BookingDTO searchBooking(int id) {
        Optional<Booking> byId = bookingRepo.findById(id);
        if (byId.isPresent()){
            return mapper.map(byId,BookingDTO.class);
        }return null;
    }

    @Override
    public void deleteBooking(String id) {

    }
}
