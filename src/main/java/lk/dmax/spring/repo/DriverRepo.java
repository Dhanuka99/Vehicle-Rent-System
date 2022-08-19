package lk.dmax.spring.repo;

import lk.dmax.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface DriverRepo extends JpaRepository<Driver,String> {

   // @Query("select d.driverNic,d.driverStatus,d.address,d.tel,d.driverName from Driver d where d.driverStatus=0")
   // ArrayList<Driver> getAvailableDrivers();

    @Query("select d.driverNic from Driver d where d.driverStatus=0")
    ArrayList getAllAvailabeDriverNic();
}
