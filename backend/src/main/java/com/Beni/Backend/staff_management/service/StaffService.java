package com.Beni.Backend.staff_management.service;

import com.Beni.Backend.staff_management.model.Staff;
import com.Beni.Backend.staff_management.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(String id) {
        return staffRepository.findById(id);
    }

    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(String id, Staff updatedStaff) {
        return staffRepository.findById(id).map(staff -> {
            staff.setName(updatedStaff.getName());
            staff.setEmail(updatedStaff.getEmail());
            staff.setPhone(updatedStaff.getPhone());
            staff.setRole(updatedStaff.getRole());
            return staffRepository.save(staff);
        }).orElse(null);
    }

    public void deleteStaff(String id) {
        staffRepository.deleteById(id);
    }
}
