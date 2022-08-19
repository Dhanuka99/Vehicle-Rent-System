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
public class Customer {
    @Id
    private String CustomerNic;

    private String name;

    private String email;

    private String password;

    private String drivingLicense;

    private String address;

    private int contactNo;

//    //customer and booking 1 to many
    @OneToMany(targetEntity = Booking.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "Cb_fk",referencedColumnName = "CustomerNic")
    private List<Booking> bookingList;

    //driver and customer m:m

    @ManyToMany(mappedBy = "customerList")
    private List<Driver> driverList;
}
