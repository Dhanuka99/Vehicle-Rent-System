package lk.dmax.spring.service.impl;

import lk.dmax.spring.dto.PackageDTO;
import lk.dmax.spring.entity.Package;
import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.repo.PackageRepo;
import lk.dmax.spring.service.VehiclePackage;
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
public class VehiclePackageImpl implements VehiclePackage {
    @Autowired
    PackageRepo packageRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void savePackage(PackageDTO packageDTO) {
        if (packageRepo.existsById(String.valueOf(packageDTO.getPackageId()))){
            throw new NotFoundException("Package already Exists");
        }packageRepo.save(mapper.map(packageDTO, Package.class));
    }

    @Override
    public void updatePackage(PackageDTO packageDTO) {
        if (packageRepo.existsById(String.valueOf(packageDTO.getPackageId()))){
            packageRepo.save(mapper.map(packageDTO, Package.class));
        }
    }

    @Override
    public ArrayList<PackageDTO> getAllPackages() {
        List<Package> allPackages = packageRepo.findAll();
        return mapper.map(allPackages,new TypeToken<ArrayList<PackageDTO>>(){}.getType());

    }

    @Override
    public void deletePackage(String id) {
        if(!packageRepo.existsById(id)){
            packageRepo.deleteById(id);
        }
    }

    @Override
    public PackageDTO searchPackage(String id) {
        Optional<Package> aPackage = packageRepo.findById(id);
        if (aPackage.isPresent()){
            return mapper.map(aPackage,PackageDTO.class);
        }
        return null;
    }
}
