package org.example.pojo.department;

import lombok.Data;
import org.example.pojo.employee.Employee;

import java.util.List;

@Data
public class Department {
    private String name;
    private List<? extends Employee> employees;
    private BudgetDetails budgetDetails;

    public Department(String name, List<? extends Employee> employees, BudgetDetails budgetDetails) {
        this.name = name;
        this.employees = employees;
        this.budgetDetails = budgetDetails;
    }
}