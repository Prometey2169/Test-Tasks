package org.example.util.factory;

import org.example.pojo.auditlog.AuditLogEntry;
import org.example.pojo.company.Company;
import org.example.pojo.department.BudgetDetails;
import org.example.pojo.department.Department;
import org.example.pojo.employee.*;
import org.example.pojo.office.Address;
import org.example.pojo.office.Capacity;
import org.example.pojo.office.Office;
import org.example.pojo.partner.ContractDetails;
import org.example.pojo.partner.Partner;
import org.example.pojo.product.Availability;
import org.example.pojo.product.Discount;
import org.example.pojo.product.PriceDetails;
import org.example.pojo.product.Product;
import org.example.pojo.report.ExpensesBreakdown;
import org.example.pojo.report.FinancialReport;
import org.example.pojo.report.RevenueStreams;

import java.util.Arrays;
import java.util.List;

public class CompanyFactory {

    public static Company buildCompany(String firstZipCode, String secondZipCode) {
        // Создание отделов
        List<Department> departments = createDepartments();

        // Создание офисов
        List<Office> offices = createOffices(firstZipCode, secondZipCode);

        // Создание продуктов
        List<Product> products = createProducts();

        // Создание финансового отчета
        FinancialReport financialReport = createFinancialReport();

        // Создание партнеров
        List<Partner> partners = createPartners();

        // Создание записей аудита
        List<AuditLogEntry> auditLogEntries = createAuditLogEntries();

        // Создание компании
        Company company = new Company(
                "TechCorp",
                departments,
                offices,
                products,
                financialReport,
                partners,
                auditLogEntries
        );

        return company;
    }

    private static List<Department> createDepartments() {
        // Создание инженеров
        List<Engineer> engineeringEmployees = Arrays.asList(
                new Engineer(1, "Alice", Arrays.asList("Java", "Spring", "Hibernate"),
                        new Contacts("alice@techcorp.com", Arrays.asList("+123456789", "+987654321")),
                        Arrays.asList(new Project(101, "Backend API", "active"), new Project(102, "Microservices", "completed"))),
                new Engineer(2, "Bob", Arrays.asList("JavaScript", "React", "Node.js"),
                        new Contacts("bob@techcorp.com", Arrays.asList("+1122334455")),
                        Arrays.asList(new Project(103, "Frontend App", "active"), new Project(104, "UI/UX Redesign", "planned")))
        );

        // Создание маркетологов
        List<Marketer> marketingEmployees = Arrays.asList(
                new Marketer(3, "Diana", Arrays.asList("SEO", "Content Marketing"),
                        new Contacts("diana@techcorp.com", Arrays.asList("+9988776655")),
                        Arrays.asList(
                                new Campaign(201, "#GrowWithUs", new ReachMetrics(50000, 1200)),
                                new Campaign(202, "#TechRevolution", new ReachMetrics(75000, 2500))
                        )
                )
        );

        // Создание отделов
        Department engineeringDept = new Department("Engineering", engineeringEmployees, new BudgetDetails(500000, 320000, 180000));
        Department marketingDept = new Department("Marketing", marketingEmployees, new BudgetDetails(200000, 120000, 80000));

        return Arrays.asList(engineeringDept, marketingDept);
    }

    private static List<Office> createOffices(String firstZipCode, String secondZipCode) {
        // Создание адресов
        Address nyAddress = new Address("123 Tech Street", "New York", "NY", firstZipCode);
        Address sfAddress = new Address("456 Innovation Blvd", "San Francisco", "CA", secondZipCode);

        // Указание вместимости офисов
        Capacity nyCapacity = new Capacity(Arrays.asList(200), Arrays.asList(150));
        Capacity sfCapacity = new Capacity(Arrays.asList(150), Arrays.asList(120));

        // Создание офисов
        Office nyOffice = new Office("New York", nyAddress, nyCapacity);
        Office sfOffice = new Office("San Francisco", sfAddress, sfCapacity);

        return Arrays.asList(nyOffice, sfOffice);
    }

    private static List<Product> createProducts() {
        // Создание продуктов
        Product superWidget = new Product(Arrays.asList(501), Arrays.asList("SuperWidget"), Arrays.asList("Widgets", "Tools", "Gadgets"),
                new PriceDetails(Arrays.asList(99.99), Arrays.asList(new Discount("seasonal", Arrays.asList(10.00))), Arrays.asList(89.99)),
                new Availability(Arrays.asList(500), Arrays.asList(150)));
        Product megaGadget = new Product(Arrays.asList(502), Arrays.asList("MegaGadget"), Arrays.asList("Gadgets", "Electronics"),
                new PriceDetails(Arrays.asList(199.99), Arrays.asList(new Discount("clearance", Arrays.asList(20.00))), Arrays.asList(179.99)),
                new Availability(Arrays.asList(300), Arrays.asList(80)));

        return Arrays.asList(superWidget, megaGadget);
    }

    private static FinancialReport createFinancialReport() {
        // Создание финансового отчета
        FinancialReport financialReport = new FinancialReport(
                new RevenueStreams(Arrays.asList(1200000), Arrays.asList(800000), Arrays.asList(400000)),
                new ExpensesBreakdown(Arrays.asList(700000), Arrays.asList(200000), Arrays.asList(150000), Arrays.asList(50000)),
                Arrays.asList(650000));
        return financialReport;
    }

    private static List<Partner> createPartners() {
        // Создание партнеров
        Partner supplyCoLtd = new Partner(Arrays.asList(901), Arrays.asList("SupplyCo Ltd."), Arrays.asList("Raw Materials", "Logistics"), new ContractDetails(Arrays.asList("2024-01-01"), Arrays.asList("2026-12-31"), Arrays.asList(1000000)));
        Partner techSolutionsInc = new Partner(Arrays.asList(902), Arrays.asList("TechSolutions Inc."), Arrays.asList("IT Support", "Cloud Hosting"), new ContractDetails(Arrays.asList("2023-06-01"), Arrays.asList("2025-05-31"), Arrays.asList(750000)));

        return Arrays.asList(supplyCoLtd, techSolutionsInc);
    }

    private static List<AuditLogEntry> createAuditLogEntries() {
        // Создание записей аудита
        AuditLogEntry loginEvent = new AuditLogEntry(Arrays.asList(1001), Arrays.asList("LOGIN"), Arrays.asList("2025-03-15T08:30:00Z"), Arrays.asList(1));
        AuditLogEntry dataExportEvent = new AuditLogEntry(Arrays.asList(1002), Arrays.asList("DATA_EXPORT"), Arrays.asList("2025-03-15T09:45:00Z"), Arrays.asList(2));
        AuditLogEntry passwordChangeEvent = new AuditLogEntry(Arrays.asList(1003), Arrays.asList("PASSWORD_CHANGE"), Arrays.asList("2025-03-16T11:20:00Z"), Arrays.asList(3));

        return Arrays.asList(loginEvent, dataExportEvent, passwordChangeEvent);
    }
}