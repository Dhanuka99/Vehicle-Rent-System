package lk.dmax.spring.service;

import lk.dmax.spring.dto.DriverDTO;
import org.springframework.data.jpa.repository.Query;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);

    void updateDriver(DriverDTO driverDTO);

    DriverDTO searchDriver(String id);

    ArrayList<DriverDTO> getAllDrivers();

    void deleteDriver(String id);

    long countDriver();


}
