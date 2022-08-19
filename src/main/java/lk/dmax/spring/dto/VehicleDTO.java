package lk.dmax.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {

    private String vehicleNo;
    private int vehicleStatus;
    private String brand;
    private int noOfPassenger;
    private String TransmissionType;
    private String fuelType;
    private String packageId;


//    private double rentDurationPrice;
//    private int dailyRate;
//    private String freeKMforday;
//    private double monthlyRate;
//    private double freeKMForMonth;
//    private double pricePerExtraKM;
}
