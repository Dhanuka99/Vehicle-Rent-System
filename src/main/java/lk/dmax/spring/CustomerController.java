package lk.dmax.spring;


import lk.dmax.spring.dto.BookingDTO;
import lk.dmax.spring.dto.CustomerDTO;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.service.CustomerService;
import lk.dmax.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path="save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO){
        if (customerDTO.getCustomerNic().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity(new StandradResponse("201", "Done", customerDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerNic().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity searchCustomer(@PathVariable String id){
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandradResponse("200","Done",customerDTO),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandradResponse("200","Done",null),HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers(){
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity(new StandradResponse("200","Done",allCustomers),HttpStatus.OK);

    }
}
