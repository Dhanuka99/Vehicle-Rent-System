package lk.dmax.spring.service.impl;

import lk.dmax.spring.service.Payment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PaymentImpl implements Payment {
    @Override
    public void savePayment() {

    }
}
