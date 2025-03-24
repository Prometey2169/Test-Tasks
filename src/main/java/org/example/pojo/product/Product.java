package org.example.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private List<Integer> productId;
    private List<String> productName;
    private List<String> categories;
    private PriceDetails priceDetails;
    private Availability availability;
}