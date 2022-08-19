package lk.dmax.spring;


import com.mysql.cj.log.Log;
import lk.dmax.spring.dto.CustomerDTO;
import lk.dmax.spring.dto.DriverDTO;
import lk.dmax.spring.dto.LoginDTO;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.service.CustomerService;
import lk.dmax.spring.service.DriverService;
import lk.dmax.spring.service.LoginService;
import lk.dmax.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    CustomerService customerService;

    @Autowired
    DriverService driverService;


    @PostMapping(path = "customer")
    public ResponseEntity loginCustomer(@RequestBody LoginDTO loginDTO){
        CustomerDTO customerDTO = customerService.searchCustomer(loginDTO.getUsernic());
        if(loginDTO.getPassword().trim().length()<=0 || loginDTO.getUserName().trim().length()<=0 || loginDTO.getUsernic().trim().length()<=0){
            throw new NotFoundException("Username or Password cant be empty");
        }else if(customerDTO!=null & customerDTO.getCustomerPassword()==loginDTO.getPassword()){
            return new ResponseEntity(new StandradResponse("201", "Done", loginDTO), HttpStatus.CREATED);
        }
        return null;
    }

    @PostMapping(path = "driver")
    public ResponseEntity loginDriver(@RequestBody LoginDTO loginDTO){
        DriverDTO driverDTO = driverService.searchDriver(loginDTO.getUsernic());
        if (loginDTO.getUsernic().trim().length()<=0|| loginDTO.getUserName().trim().length()<=0 || loginDTO.getPassword().trim().length()<=0){
        throw new NotFoundException("User name or password cant empty");
    }else if(driverDTO!=null ){
            return new ResponseEntity(new StandradResponse("201", "Done", loginDTO), HttpStatus.CREATED);
        }
   return null;

    }

    @GetMapping(path = "driver")
    public ResponseEntity searchCustomer(@RequestBody LoginDTO loginDTO){

        return new ResponseEntity(new StandradResponse("201", "Done", loginDTO), HttpStatus.CREATED);
    }
}
