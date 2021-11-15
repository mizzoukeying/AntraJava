package com.keying.antra.restAPI.Service.ServiceImp;

import com.keying.antra.restAPI.DAO.entity.Department;
import com.keying.antra.restAPI.DAO.repository.DeptRepository;
import com.keying.antra.restAPI.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeptServiceImp implements DeptService {

    private final DeptRepository dr;


    @Autowired
    public DeptServiceImp(DeptRepository dr) {
        this.dr=dr;
    }

    @Override
    public List<Department> getAllDept() {
        return dr.getAllDept();
    }

    @Override
    public Department getDeptById(Integer Id) {
        return dr.getDeptbyId(Id);
    }
}
