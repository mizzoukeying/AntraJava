package com.keying.firstspringboot.service.Imp;

import com.keying.firstspringboot.entity.Emp;
import com.keying.firstspringboot.respository.EmpRepository;
import com.keying.firstspringboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp implements EmpService {


    private final EmpRepository empRepository;

    @Autowired
    public EmpServiceImp(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<Emp> getAll() {
        return empRepository.getAll();
    }

    @Override
    public Emp getById(Long id) {
        return empRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        empRepository.deleteById(id);
    }

    @Override
    public void update(long id, Emp emp) {
        empRepository.updateEmp(emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), id);
    }




}