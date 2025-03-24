package org.example.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    private List<Integer> onlineStock;
    private List<Integer> storeStock;
}