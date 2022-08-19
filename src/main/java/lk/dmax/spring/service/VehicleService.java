package lk.dmax.spring.service;

import lk.dmax.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {

    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO searchVehicle(String id);

    ArrayList<VehicleDTO> getAllVehicles();

    void deleteVehicle(String id);
}
