package com.keying.firstspringboot.controller;

import com.keying.firstspringboot.entity.Emp;
import com.keying.firstspringboot.service.EmpService;
import com.keying.firstspringboot.utility.ResponseData;
import com.keying.firstspringboot.respository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {


    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PutMapping("/{id}")
    public ResponseData updateEmp(@PathVariable Long id, @RequestBody Emp emp) {
        Emp curEmp = empService.getById(id);
        if (curEmp != null) {
            empService.update(id, emp);
            return ResponseData.success(emp, "Updated employee with ID : " + id);
        } else {
            return ResponseData.failed(HttpStatus.NOT_FOUND.toString());
        }

    }


    @GetMapping
    public ResponseData getAllEmp() {
        List<Emp> empList = empService.getAll();
        if (empList == null) {
            return ResponseData.failed(HttpStatus.NO_CONTENT.toString());
        }
        return ResponseData.success(empList);
    }

    @GetMapping("{id}")
    public ResponseData getEmpById(@PathVariable Long id) {
        Emp emp = empService.getById(id);
        if (emp == null) {

            return ResponseData.failed("Employee not found");
        }
        return ResponseData.success(emp);
    }



    @DeleteMapping("/{id}")
    public ResponseData deleteEmpById(@PathVariable Long id) {
        Emp curEmp = empService.getById(id);
        if (curEmp != null) {
            empService.deleteById(id);
            return ResponseData.success("Deleted employee with ID" + id);
        }
        return ResponseData.failed(HttpStatus.NOT_FOUND.toString());

    }





}