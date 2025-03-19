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
            staff.setAssignedEvents(updatedStaff.getAssignedEvents());
            staff.setCheckInTime(updatedStaff.getCheckInTime());
            staff.setCheckOutTime(updatedStaff.getCheckOutTime());
            staff.setEarnings(updatedStaff.getEarnings());
            staff.setRatings(updatedStaff.getRatings());
            staff.setAvailability(updatedStaff.getAvailability()); // Updating availability slots
            return staffRepository.save(staff);
        }).orElse(null);
    }

    public void deleteStaff(String id) {
        staffRepository.deleteById(id);
    }

    public List<Staff.Availability> getStaffAvailability(String id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.map(Staff::getAvailability).orElse(null); // Return list of availability slots
    }

    public Staff updateAvailability(String id, List<Staff.Availability> updatedAvailability) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()) {
            Staff s = staff.get();
            s.setAvailability(updatedAvailability); // Update availability slots
            return staffRepository.save(s);
        }
        return null;
    }

    public Staff assignPhotographerToEvent(String id, String eventName) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()) {
            Staff s = staff.get();
            // Check availability for the event date
            for (Staff.Availability slot : s.getAvailability()) {
                if (slot.isAvailable()) {
                    s.getAssignedEvents().add(eventName);
                    slot.setAvailable(false); // Set to unavailable after assignment
                    return staffRepository.save(s);
                }
            }
        }
        return null; // Return null if no availability found
    }
}
