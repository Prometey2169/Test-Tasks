package org.example.pojo.auditlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogEntry {
    private List<Integer> eventId;
    private List<String> eventType;
    private List<String> timestamp;
    private List<Integer> userId;
}
