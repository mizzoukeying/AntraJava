package com.keying.antra.restAPI.Controller;

import com.keying.antra.restAPI.DAO.entity.Department;
import com.keying.antra.restAPI.Service.DeptService;
import com.keying.antra.restAPI.Utilities.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")

public class DeptController {
    private final DeptService ds;

    @Autowired
    public DeptController(DeptService ds) {
        this.ds = ds;
    }

    @GetMapping
    public ResponseData getAllDept(){
        List<Department> deptList = ds.getAllDept();
        return ResponseData.buildSuccess(200,null, "Success");
    }

    @GetMapping("/{id}")
    public ResponseData getDeptById(@PathVariable Integer id){
        Department dept = ds.getDeptById(id);
        if(dept == null){
            return ResponseData.buildError(404, "NOT FOUND");
        }

        return ResponseData.buildSuccess(200, dept,"Success");
    }



}
