package com.Beni.Backend.package_management.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "photography_packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    @Id
    private String id;
    private String name;
    private double price;
    private String description;
    private List<String> customizations; // List of customization options
}

