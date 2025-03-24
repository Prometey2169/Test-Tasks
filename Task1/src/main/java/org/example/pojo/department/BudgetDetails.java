package org.example.pojo.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDetails {
    private int annualBudget;
    private int spentBudget;
    private int remainingBudget;
}
