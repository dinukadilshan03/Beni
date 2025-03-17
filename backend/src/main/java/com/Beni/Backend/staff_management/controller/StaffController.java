package com.Beni.Backend.staff_management.controller;

import com.Beni.Backend.staff_management.model.Staff;
import com.Beni.Backend.staff_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable String id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable String id, @RequestBody Staff updatedStaff) {
        return staffService.updateStaff(id, updatedStaff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable String id) {
        staffService.deleteStaff(id);
    }
}
