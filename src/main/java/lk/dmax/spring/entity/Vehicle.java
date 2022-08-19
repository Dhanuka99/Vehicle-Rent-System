package lk.dmax.spring.entity;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    private String vehicleNo;
    private String packageId;
    private int vehicleStatus;
    private String brand;
    private int noOfPassenger;
    private String TransmissionType;
    private String fuelType;
}
