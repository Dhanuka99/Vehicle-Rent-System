package lk.dmax.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @OneToOne
    private Customer customerNic;
    @OneToOne
    private Vehicle vehicleNo;
    @OneToOne
    private Driver driverNic;
    private String bookingDate;
    private String bookingTime;
    private String bookingStatus;
    private String returnDate;
    private String returnTime;
    private double startMileage;
    private double endMileage;
    private String releaseStatus;
}
