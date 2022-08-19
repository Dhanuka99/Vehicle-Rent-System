package lk.dmax.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDTO {

    private String packageId;
    private double dailyRate;
    private double freeKMforday;
    private double monthlyRate;
    private double freeKMForMonth;
    private double pricePerExtraKM;

}
