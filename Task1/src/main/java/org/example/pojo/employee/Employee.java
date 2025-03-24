package org.example.pojo.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    protected int id;
    protected String name;
    protected List<String> skills;
    protected Contacts contacts;


}
