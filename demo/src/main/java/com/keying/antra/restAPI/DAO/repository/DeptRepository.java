package com.keying.antra.restAPI.DAO.repository;

import com.keying.antra.restAPI.DAO.entity.Department;
import com.keying.antra.restAPI.DAO.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepository extends JpaRepository<Department, Integer> {
    @Query(value="SELECT * FROM DEPARTMENT", nativeQuery=true)
    List<Department> getAllDept();

    //对于JPQL中的索引参数，Spring Data会将方法参数按照在方法声明中出现的顺序传递给查询：
    @Query(value="SELECT * FROM DEPARTMENT D WHERE D.DEPT_ID=?1", nativeQuery=true)
    Department getDeptbyId(Integer deptID);
}
