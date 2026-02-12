package com.company.payroll.controller;



import com.company.payroll.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private PayrollRepository payrollRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("payrolls", payrollRepo.findAll());
        return "dashboard";
    }

    @GetMapping("/addEmployee")
    public String addEmployeePage(){
        return "addEmployee";
    }
}

