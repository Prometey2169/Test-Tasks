package org.example.pojo.employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    private int id;
    private String title;
    private ReachMetrics reachMetrics;
}
