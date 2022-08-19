package lk.dmax.spring.repo;

import lk.dmax.spring.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PackageRepo extends JpaRepository<Package,String> {

    @Query("select packageId from Package")
    ArrayList getAllPackageId();
}
