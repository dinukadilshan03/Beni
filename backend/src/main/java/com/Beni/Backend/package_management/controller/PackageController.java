package com.Beni.Backend.package_management.controller;

import com.Beni.Backend.package_management.model.Package;
import com.Beni.Backend.package_management.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageService service;

    // Create a new package
    @PostMapping
    public Package createPackage(@RequestBody Package packageObj) {
        return service.createPackage(packageObj);
    }

    // Get all packages
    @GetMapping
    public List<Package> getAllPackages() {
        return service.getAllPackages();
    }

    // Get a package by ID
    @GetMapping("/{id}")
    public Package getPackageById(@PathVariable String id) {
        return service.getPackageById(id);
    }

    // Update a package
    @PutMapping("/{id}")
    public Package updatePackage(@PathVariable String id, @RequestBody Package updatedPackage) {
        return service.updatePackage(id, updatedPackage);
    }

    // Delete a package
    @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable String id) {
        service.deletePackage(id);
        return "Package deleted with id: " + id;
    }

    // Add customizations to a package
    @PostMapping("/{id}/customizations")
    public Package addCustomizations(@PathVariable String id, @RequestBody List<String> customizations) {
        return service.addCustomizations(id, customizations);
    }
}
