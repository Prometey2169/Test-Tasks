package org.example.pojo.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    private List<Integer> partnerId;
    private List<String> partnerName;
    private List<String> servicesProvided;
    private ContractDetails contractDetails;
}