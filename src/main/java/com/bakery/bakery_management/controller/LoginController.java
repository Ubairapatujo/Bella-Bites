package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.employee;
import com.bakery.bakery_management.repository.employeerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private employeerepository employeeRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "redirect:/dashboard.html";
    }

    @GetMapping("/employee/dashboard")
    public String employeeDashboard(Authentication authentication, Model model) {
        String username = authentication.getName();
        employee emp = employeeRepository.findByUsername(username).orElse(null);
        if (emp != null) {
            model.addAttribute("employeeName", emp.getEmployeeName());
            model.addAttribute("employeeId", emp.getEmployeeId());
        }
        return "employee-dashboard";
    }
}