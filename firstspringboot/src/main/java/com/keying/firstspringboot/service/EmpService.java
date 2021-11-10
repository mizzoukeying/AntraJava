package com.keying.firstspringboot.service;

import com.keying.firstspringboot.entity.Emp;

import java.util.List;


public interface EmpService {

    Emp getById(Long id);

    List<Emp> getAll();

    void deleteById(Long id);

    void update(long id, Emp emp);

}

