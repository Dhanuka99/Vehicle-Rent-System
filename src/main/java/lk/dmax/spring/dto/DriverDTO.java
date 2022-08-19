package lk.dmax.spring.dto;


import lk.dmax.spring.MtoM.Booking;
import lk.dmax.spring.MtoM.Customer;
import lk.dmax.spring.MtoM.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driverNic;
    private String driverLicenseNo;
    private String driverName;
    private String driverAddress;
    private String driverTel;

    private int driverStatus;


    //    private List<Booking> bookingList;
//
//    private List<Customer> customerList;
//
//    private List<Vehicle> vehicleList;


}
