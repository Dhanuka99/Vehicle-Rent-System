package lk.dmax.spring.MtoM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    private String vehicleNo;

    private int vehicleStatus;

    private String brand;

    private String type;

    private int noOfPassenger;

    private String TransmissionType;

    private String fuelType;

    public Vehicle(String vehicleNo, String brand, String type, int noOfPassenger, String transmissionType, String fuelType) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.type = type;
        this.noOfPassenger = noOfPassenger;
        TransmissionType = transmissionType;
        this.fuelType = fuelType;
    }

    public Vehicle(String vehicleNo, int vehicleStatus, String brand, String type, int noOfPassenger, String transmissionType) {
        this.vehicleNo = vehicleNo;
        this.vehicleStatus = vehicleStatus;
        this.brand = brand;
        this.type = type;
        this.noOfPassenger = noOfPassenger;
        TransmissionType = transmissionType;
    }

    //    //booking and vehicle m:m relationship
    @ManyToMany(mappedBy = "vehicleList")
    private List<Booking> bookingList;

    //driver and vehicle 1 to 1
    @OneToOne
    private Driver driver;

    //vehicle and driver m:m
    @ManyToMany(mappedBy = "vehicleList")
    private List<Driver> driverList;
}
