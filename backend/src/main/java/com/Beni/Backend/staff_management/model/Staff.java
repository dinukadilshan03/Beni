package com.Beni.Backend.staff_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "staff")
public class Staff {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String role;
}
