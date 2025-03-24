package org.example.pojo.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueStreams {
    private List<Integer> onlineSales;
    private List<Integer> retailSales;
    private List<Integer> subscriptionsAndServices;
}
