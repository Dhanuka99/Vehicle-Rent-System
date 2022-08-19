package lk.dmax.spring.repo;

import lk.dmax.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
//
//    @Query("select v from Vehicle v where v.vehicleStatus=1")
//    ArrayList<VehicleDTO> getAvailableVehicles();

   // long countByVehicleNo();

    @Query("select v.vehicleNo from Vehicle v where v.vehicleStatus=0")
    ArrayList getAllAvailableVehicleNo();
}
