package org.example.pojo.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialReport {
    private RevenueStreams revenueStreams;
    private ExpensesBreakdown expensesBreakdown;
    private List<Integer> netProfitQuarterly;
}