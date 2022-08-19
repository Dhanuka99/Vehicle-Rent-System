package lk.dmax.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    private String driverNic;
    private int driverStatus;
    private String driverName;
    private String driverAddress;
    private String driverTel;
    private String driverLicenseNo;

}
