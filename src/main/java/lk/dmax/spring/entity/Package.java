package lk.dmax.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

}
