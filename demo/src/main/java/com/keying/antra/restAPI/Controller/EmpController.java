package com.keying.antra.restAPI.Controller;



import com.keying.antra.restAPI.DAO.entity.Employee;
import com.keying.antra.restAPI.Service.EmpService;
import com.keying.antra.restAPI.Utilities.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//将本方法映射到/emp
@RestController
@RequestMapping("/emp")

public class EmpController {
    private final EmpService es;

    @Autowired
    public EmpController(EmpService es) {
        this.es = es;
    }

    @GetMapping
    public ResponseData getAllDept(){
        List<Employee> empList = es.getAllEmp();
        return ResponseData.buildSuccess(200,null, "Success");
    }

    @GetMapping("/{id}")
    public ResponseData getDeptById(@PathVariable Integer id){
        Employee emp= es.getEmpById(id);
        if(emp == null){
            return ResponseData.buildError(404, "NOT FOUND");
        }

        return ResponseData.buildSuccess(200, emp,"Success");
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteDeptById(@PathVariable Integer id){
        Employee emp= es.getEmpById(id);
        if(emp == null){
            return ResponseData.buildError(404, "NOT FOUND");
        }

        es.deleteById(id);
        return ResponseData.buildSuccess(200, emp,"Success");
    }

}
