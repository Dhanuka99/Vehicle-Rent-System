package lk.dmax.spring.service;

import lk.dmax.spring.dto.LoginDTO;

public interface LoginService {

    boolean loginCustomer(LoginDTO loginDTO);

    boolean loginDriver(LoginDTO loginDTO);
}
