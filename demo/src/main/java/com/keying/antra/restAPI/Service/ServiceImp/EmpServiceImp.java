package com.keying.antra.restAPI.Service.ServiceImp;

import com.keying.antra.restAPI.DAO.entity.Employee;
import com.keying.antra.restAPI.DAO.repository.EmpRepository;
import com.keying.antra.restAPI.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmpServiceImp implements EmpService {
    //construction inject
    private final EmpRepository er;

    @Autowired
    public EmpServiceImp(EmpRepository er) {

        this.er = er;
    }

    @Override
    public List<Employee> getAllEmp() {
        return er.getAllEmployee();
    }

    @Override
    public Employee getEmpById(Integer Id) {
        return er.getEmployeeByID(Id);
    }

    @Override
    public void deleteById(Integer id){
        er.deleteById(id);
    }
}
