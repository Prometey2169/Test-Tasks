package org.example.pojo.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetails {
    private List<String> startDate;
    private List<String> endDate;
    private List<Integer> contractValue;
}