package org.example.pojo.office;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capacity {
    private List<Integer> totalSeats;
    private List<Integer> occupiedSeats;
}