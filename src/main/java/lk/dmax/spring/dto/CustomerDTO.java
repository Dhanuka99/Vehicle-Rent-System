package lk.dmax.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private String customerNic;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerTel;
    private String customerPassword;
    private String customerDrivingLicense;

}
