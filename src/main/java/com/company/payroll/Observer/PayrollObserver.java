package com.company.payroll.Observer;

import com.company.payroll.entity.Payroll;

public interface PayrollObserver {
    void notify(Payroll payroll);
}
