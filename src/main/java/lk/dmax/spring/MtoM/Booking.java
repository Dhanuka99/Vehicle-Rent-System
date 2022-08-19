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
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue
    private int bookingId;
    private String CustomerNic;
    private String vehicleNo;
    private String driverId;
    private String bookingDate;
    private String bokingTime;
    private String returnDate;
    private String returnTime;
    private int bookingStatus;





//    //booking and vehicle m:m relationship

    @ManyToMany
    @JoinTable(
            name = "Booking_Vehicle",
            joinColumns = @JoinColumn(name = "bookingId"),
            inverseJoinColumns = @JoinColumn(name = "vehicleNo")
    )
    private List<Vehicle> vehicleList;

    //booking and driver m:m relationship

    @ManyToMany
    @JoinTable(
            name = "Booking_Driver",
            joinColumns = @JoinColumn(name = "bookingId"),
            inverseJoinColumns = @JoinColumn(name = "driverNic")
    )
    private List<Driver> driverList;
}
