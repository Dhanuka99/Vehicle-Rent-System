package lk.dmax.spring;

import lk.dmax.spring.dto.CustomerDTO;
import lk.dmax.spring.dto.PackageDTO;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.repo.PackageRepo;
import lk.dmax.spring.repo.VehicleRepo;
import lk.dmax.spring.service.CustomerService;
import lk.dmax.spring.service.VehiclePackage;
import lk.dmax.spring.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin
@RestController
@RequestMapping("api/package")
public class VehiclePackageController {


    @Autowired
    VehiclePackage vehiclePackage;

    @Autowired
    ModelMapper mapper;

    @Autowired
    PackageRepo packageRepo;



    @PostMapping(path="save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePackage(@RequestBody PackageDTO packageDTO){
        System.out.println(packageDTO.toString());
        if (packageDTO.getPackageId().trim().length() <= 0) {
            throw new NotFoundException("Package id cannot be empty");
        }
        vehiclePackage.savePackage(packageDTO);
        return new ResponseEntity(new StandradResponse("201", "Done", packageDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePackage(@RequestBody PackageDTO packageDTO) {
        if (packageDTO.getPackageId().trim().length() <= 0) {
            throw new NotFoundException("No pkg id provided to update");
        }
        vehiclePackage.updatePackage(packageDTO);
        return new ResponseEntity(new StandradResponse("200", "Done", packageDTO), HttpStatus.OK);
    }

    @GetMapping("getPackageID")
    public ResponseEntity getAllPackageID(){
        ArrayList allPackageId = packageRepo.getAllPackageId();

        return new ResponseEntity(new StandradResponse("200", "Done", allPackageId), HttpStatus.OK);
    }
}
