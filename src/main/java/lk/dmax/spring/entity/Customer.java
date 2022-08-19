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
public class Customer {
    @Id
    private String customerNic;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerTel;
    private String customerPassword;
    private String customerDrivingLicense;
}
