package lk.dmax.spring;


import lk.dmax.spring.dto.VehicleDTO;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.repo.DriverRepo;
import lk.dmax.spring.repo.VehicleRepo;
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
@RequestMapping("api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @PostMapping(path="save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO vehicleDTO){

        if (vehicleDTO.getVehicleNo().trim().length() <= 0) {
            throw new NotFoundException("Vehicle No cannot be empty");
        }
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseEntity(new StandradResponse("200", "Done", vehicleDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVehicleNo().trim().length() <= 0) {
            throw new NotFoundException("No Vehicle provided to update");
        }
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity(new StandradResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }

    @GetMapping("getAvailableVehicleNo")
    public ResponseEntity getAllAvailableDriverNic(){
        ArrayList allVehicleNo = vehicleRepo.getAllAvailableVehicleNo();
        return new ResponseEntity(new StandradResponse("200", "Done", allVehicleNo), HttpStatus.OK);
    }
}
