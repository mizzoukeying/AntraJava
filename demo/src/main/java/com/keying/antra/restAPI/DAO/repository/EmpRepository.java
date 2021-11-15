package com.keying.antra.restAPI.DAO.repository;

import com.keying.antra.restAPI.DAO.entity.Department;
import com.keying.antra.restAPI.DAO.entity.Employee;

//将类识别为Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{

//        getEmployee

    @Query(value = "SELECT * FROM EMPLOYEE", nativeQuery=true)
    List<Employee> getAllEmployee();

    @Query(value = "SELECT * FROM EMPLOYEE where emp_id=?1", nativeQuery=true)
    Employee getEmployeeByID(Integer empID);


    @Modifying
    @Query("delete from Employee e where e.id = ?1")
    void deleteById(Long id);



}
