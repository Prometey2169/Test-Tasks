package org.example.pojo.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesBreakdown {
    private List<Integer> salaryExpenses;
    private List<Integer> marketingExpenses;
    private List<Integer> infrastructureExpenses;
    private List<Integer> miscellaneousExpenses;
}
