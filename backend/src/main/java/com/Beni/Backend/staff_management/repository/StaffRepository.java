package com.Beni.Backend.staff_management.repository;

import com.Beni.Backend.staff_management.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}
