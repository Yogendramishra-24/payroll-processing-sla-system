package com.company.payroll.Observer;

import com.company.payroll.entity.Payroll;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationObserver implements PayrollObserver {
    @Override
    public void notify(Payroll payroll) {

        System.out.println("Sending failure email for payroll " + payroll.getId());
    }
}
