package lk.dmax.spring.entity;

import lk.dmax.spring.MtoM.Booking;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Payment {

    @Id
    private int paymentId;
    private int bookingId;
    private double damageWaiver;
    private double extraKm;
    private double extraAmount;
    private String payDate;
    private String payTime;
    private double finalAmonut;

}
