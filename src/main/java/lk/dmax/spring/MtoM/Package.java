package lk.dmax.spring.MtoM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Package {

    @Id
    private String packageId;

    private double dailyRate;

    private double freeKMforday;

    private double monthlyRate;

    private double freeKMForMonth;

    private double pricePerExtraKM;

    //    //pkg and vehicle 1 to many
    @OneToMany(targetEntity = Vehicle.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pv_fk",referencedColumnName = "packageId")
    private List<Booking> bookingList;
}
