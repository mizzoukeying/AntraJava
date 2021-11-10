package com.keying.firstspringboot.controller;

import com.keying.firstspringboot.entity.Dept;
import com.keying.firstspringboot.entity.Emp;
import com.keying.firstspringboot.service.DeptService;
import com.keying.firstspringboot.utility.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {

        this.deptService = deptService;
    }

    @GetMapping
    public ResponseData getAllDept(){
        List<Dept> deptList = deptService.getAllDept();
        return ResponseData.success(deptList);
    }

    @GetMapping("/{id}")
    public ResponseData getDepById(@PathVariable("id") Integer deptId){
        Dept dept = deptService.getDeptById(deptId);
        if(dept == null){
            return ResponseData.failed(deptId + "doesn't exists");
        }
        return ResponseData.success(dept,"Successful");
    }

    @GetMapping("/{id}/employees")
    public Set<Emp> getEmpByDept(Integer deptId) {

        return deptService.getEmpByDept(deptId);
    }

}