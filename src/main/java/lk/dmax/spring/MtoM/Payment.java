package lk.dmax.spring.MtoM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    @Id
    private String paymentId;

    @OneToOne
    private Booking booking;

    private double damageWaiver;

    private double extraKm;

    private double extraAmount;

    @Basic
    private java.sql.Date payDate;

    @Basic
    private java.sql.Time payTime;

    private double finalAmonut;








}
