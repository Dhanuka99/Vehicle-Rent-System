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
public class Driver {

    @Id
    private String driverNic;

    private int driverStatus;

    private String driverName;

    private String address;

    private String tel;



//    //booking and driver m:m relationship
    @ManyToMany(mappedBy = "driverList")
    private List<Booking> bookingList;

    //driver and customer m:m

    @ManyToMany
    @JoinTable(
            name = "Customer_Driver",
            joinColumns = @JoinColumn(name = "driverNic"),
            inverseJoinColumns = @JoinColumn(name = "CustomerNic")
    )
    private List<Customer> customerList;

    //vehicle and driver m:m

    @ManyToMany
    @JoinTable(
            name = "Driver_Vehicle",
            joinColumns = @JoinColumn(name = "driverNic"),
            inverseJoinColumns = @JoinColumn(name = "vehicleNo")
    )
    private List<Vehicle> vehicleList;
}
