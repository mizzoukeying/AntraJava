package com.keying.firstspringboot.respository;

import com.keying.firstspringboot.entity.Dept;
import com.keying.firstspringboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {

    @Query(value = "SELECT * From department", nativeQuery = true)
    List<Dept> getAllDept();

    @Query(value = "SELECT * FROM department  d where d.dept_id = ?1", nativeQuery = true)
    Dept getDeptById(Integer depId);

    @Query(value = "SELECT e.* FROM emp e RIGHT JOIN department d ON e.dept_id = d.dept_id", nativeQuery = true)
    Set<Emp> getEmpByDept(Integer deptId);


}
