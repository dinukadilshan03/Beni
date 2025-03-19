package com.Beni.Backend.staff_management.repository;

import com.Beni.Backend.staff_management.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
    List<Staff> findByRole(String role);
    List<Staff> findByAvailability(boolean availability);
}
