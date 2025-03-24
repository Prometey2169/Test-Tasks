package org.example.pojo.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engineer extends Employee {
    private List<Project> projects;

    public Engineer(int id, String name, List<String> skills, Contacts contacts, List<Project> projects) {
        super(id, name, skills, contacts);
        this.projects = projects;
    }
}
