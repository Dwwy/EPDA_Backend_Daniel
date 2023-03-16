package com.test.testing.Dao;

import com.test.testing.Model.Staff;

import java.util.List;

public interface StaffDAOI {
    boolean createStaff(Staff staff);
    boolean updateStaff(Staff staff);
    void deleteStaff(Staff staff);
    List<Staff> getAllStaffs();
    Staff getStaffbyId(String id);
    Staff getStaffbyUserID(String id);
}
