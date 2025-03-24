package org.example.pojo.office;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {
    private String location;
    private Address address;
    private Capacity capacity;
}