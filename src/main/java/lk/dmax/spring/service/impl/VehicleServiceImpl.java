package lk.dmax.spring.service.impl;

import lk.dmax.spring.dto.VehicleDTO;
import lk.dmax.spring.entity.Vehicle;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.repo.DriverRepo;
import lk.dmax.spring.repo.VehicleRepo;
import lk.dmax.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {

        if (vehicleRepo.existsById(vehicleDTO.getVehicleNo())){
            throw new NotFoundException("Vehicle Already Exists.");
        }
        vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if(vehicleRepo.existsById(vehicleDTO.getVehicleNo())){
            vehicleRepo.save(mapper.map(vehicleDTO,Vehicle.class));
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isPresent()){
            return mapper.map(vehicle,VehicleDTO.class);
        }return null;

    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepo.findAll();
        return mapper.map(allVehicles,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());

    }

    @Override
    public void deleteVehicle(String id) {
        if (!vehicleRepo.existsById(id)){
            throw new NotFoundException("No Vehicle For Delete.");
        }vehicleRepo.deleteById(id);
    }
}
