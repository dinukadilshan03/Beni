package com.Beni.Backend.package_management.service;

import com.Beni.Backend.package_management.model.Package;
import com.Beni.Backend.package_management.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageRepository repository;

    // Create a new package
    public Package createPackage(Package packageObj) {
        return repository.save(packageObj);
    }

    // Get all packages
    public List<Package> getAllPackages() {
        return repository.findAll();
    }

    // Get a package by ID
    public Package getPackageById(String id) {
        return repository.findById(id).orElse(null);
    }

    // Update a package
    public Package updatePackage(String id, Package updatedPackage) {
        Package existingPackage = repository.findById(id).orElse(null);
        if (existingPackage != null) {
            existingPackage.setName(updatedPackage.getName());
            existingPackage.setPrice(updatedPackage.getPrice());
            existingPackage.setDescription(updatedPackage.getDescription());
            existingPackage.setCustomizations(updatedPackage.getCustomizations());
            return repository.save(existingPackage);
        }
        return null;
    }

    // Delete a package
    public void deletePackage(String id) {
        repository.deleteById(id);
    }

    // Add customizations to a package
    public Package addCustomizations(String id, List<String> customizations) {
        Package existingPackage = repository.findById(id).orElse(null);
        if (existingPackage != null) {
            existingPackage.getCustomizations().addAll(customizations);
            return repository.save(existingPackage);
        }
        return null;
    }
}
