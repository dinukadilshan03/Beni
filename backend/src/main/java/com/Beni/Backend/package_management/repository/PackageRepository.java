package com.Beni.Backend.package_management.repository;

import com.Beni.Backend.package_management.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PackageRepository extends MongoRepository<Package, String> {
    List<Package> findByName(String name);
}
