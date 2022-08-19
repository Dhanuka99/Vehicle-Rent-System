package lk.dmax.spring.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {
    private int bookingId;
    private String customerNic;
    private String vehicleNo;
    private String driverNic;
    private String bookingDate;
    private String bookingTime;
    private String bookingStatus;
    private String returnDate;
    private String returnTime;
    private double startMileage;
    private double endMileage;
    private String releaseStatus;
}
