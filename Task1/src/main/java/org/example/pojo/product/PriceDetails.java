package org.example.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetails {
    private List<Double> basePrice;
    private List<Discount> discounts;
    private List<Double> finalPrice;
}