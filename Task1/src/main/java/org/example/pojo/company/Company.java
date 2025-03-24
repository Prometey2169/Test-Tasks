package org.example.pojo.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.pojo.auditlog.AuditLogEntry;
import org.example.pojo.department.Department;
import org.example.pojo.office.Office;
import org.example.pojo.partner.Partner;
import org.example.pojo.product.Product;
import org.example.pojo.report.FinancialReport;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("company")
public class Company {
    private String name;
    private List<Department> departments;
    private List<Office> offices;
    private List<Product> products;
    private FinancialReport financialReport2025Q1;
    private List<Partner> partnersAndSuppliers;
    private List<AuditLogEntry> auditLog;

}
