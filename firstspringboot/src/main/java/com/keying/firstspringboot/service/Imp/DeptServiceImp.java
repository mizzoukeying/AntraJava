package com.keying.firstspringboot.service.Imp;

import com.keying.firstspringboot.entity.Dept;
import com.keying.firstspringboot.entity.Emp;
import com.keying.firstspringboot.respository.DeptRepository;
import com.keying.firstspringboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DeptServiceImp implements DeptService {

    private final DeptRepository deptRepository;

    @Autowired
    public DeptServiceImp(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public List<Dept> getAllDept() {

        return deptRepository.getAllDept();
    }

    @Override
    public Dept getDeptById(Integer deptId) {

        return deptRepository.getDeptById(deptId);
    }

    @Override
    public Set<Emp> getEmpByDept(Integer deptId) {

        return deptRepository.getEmpByDept(deptId);
    }




}