package lk.dmax.spring;

import lk.dmax.spring.dto.BookingDTO;
import lk.dmax.spring.dto.CustomerDTO;
import lk.dmax.spring.dto.DriverDTO;
import lk.dmax.spring.dto.VehicleDTO;
import lk.dmax.spring.repo.BookingRepo;
import lk.dmax.spring.repo.DriverRepo;
import lk.dmax.spring.repo.VehicleRepo;
import lk.dmax.spring.service.BookingService;
import lk.dmax.spring.service.CustomerService;
import lk.dmax.spring.service.DriverService;
import lk.dmax.spring.service.VehicleService;
import lk.dmax.spring.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin
@RestController
@RequestMapping("api/booking")
public class BookingController {

        @Autowired
        BookingService bookingService;


    @PostMapping(path = "placeBooking",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity placeBooking(@RequestBody BookingDTO bookingDTO){
        System.out.println("placbooking stat");
        bookingService.saveBooking(bookingDTO);
        return new ResponseEntity(new StandradResponse("201","done",bookingDTO),HttpStatus.OK);
    }

}
