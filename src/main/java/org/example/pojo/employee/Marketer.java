package org.example.pojo.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marketer extends Employee {
    private List<Campaign> campaignsManaged;

    public Marketer(int id, String name, List<String> skills, Contacts contacts, List<Campaign> campaignsManaged) {
        super(id, name, skills, contacts);
        this.campaignsManaged = campaignsManaged;
    }
}
