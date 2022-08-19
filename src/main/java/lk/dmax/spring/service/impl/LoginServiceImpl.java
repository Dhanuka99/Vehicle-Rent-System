package lk.dmax.spring.service.impl;

import lk.dmax.spring.dto.LoginDTO;
import lk.dmax.spring.repo.CustomerRepo;
import lk.dmax.spring.repo.DriverRepo;

import lk.dmax.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;


    @Override
    public boolean loginCustomer(LoginDTO loginDTO) {
        boolean b = customerRepo.existsById(loginDTO.getUsernic());
        if (b){
            loginDTO.setUserStatus("logIn");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean loginDriver(LoginDTO loginDTO) {
        boolean b = driverRepo.existsById(loginDTO.getUsernic());
        if (b){
            loginDTO.setUserStatus("logIn");
            return true;
        }else{
            return false;
        }
    }
}
