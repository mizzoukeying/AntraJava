package com.keying.antra.restAPI.Service;

import com.keying.antra.restAPI.DAO.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {

    List<Employee> getAllEmp();

    Employee getEmpById(Integer Id);

    void deleteById(Integer Id);

}
