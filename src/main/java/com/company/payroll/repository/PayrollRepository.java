package com.company.payroll.repository;

import com.company.payroll.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByStatusAndSlaDeadlineBefore(String status,
                                                   LocalDateTime time);
}
