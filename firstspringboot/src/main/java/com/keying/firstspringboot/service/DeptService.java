package com.keying.firstspringboot.service;

import com.keying.firstspringboot.entity.Dept;
import com.keying.firstspringboot.entity.Emp;

import java.util.List;
import java.util.Set;

public interface DeptService {

    List<Dept> getAllDept();

    Dept getDeptById(Integer deptId);

    Set<Emp> getEmpByDept(Integer depId);
}