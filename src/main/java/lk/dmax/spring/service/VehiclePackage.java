package lk.dmax.spring.service;

import lk.dmax.spring.dto.PackageDTO;

import java.util.ArrayList;

public interface VehiclePackage {
    void savePackage(PackageDTO packageDTO);

    void updatePackage(PackageDTO packageDTO);

    ArrayList<PackageDTO> getAllPackages();

    void deletePackage(String id);

    PackageDTO searchPackage(String id);
}
