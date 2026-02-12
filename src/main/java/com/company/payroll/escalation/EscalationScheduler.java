package com.company.payroll.escalation;

import com.company.payroll.entity.Payroll;
import com.company.payroll.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
@EnableScheduling
public class EscalationScheduler {
    @Autowired
    private PayrollRepository payrollRepo;

    @Scheduled(fixedRate = 60000)
    public void checkFailures(){

        List<Payroll> failed =
                payrollRepo.findByStatusAndSlaDeadlineBefore(
                        "FAILED", LocalDateTime.now());

        failed.forEach(p ->
                System.out.println("Escalating payroll " + p.getId())
        );
    }
}
