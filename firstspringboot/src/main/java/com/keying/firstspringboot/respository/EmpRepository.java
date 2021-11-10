package com.keying.firstspringboot.respository;


import com.keying.firstspringboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {

    @Query(value = "SELECT * From Employee",  nativeQuery = true)
    List<Emp> getAll();

    @Query(value = "SELECT e from Emp e where e.id =?1", nativeQuery = true)
    Emp getById(Long id);

    @Query(
            value = "select * from emp e where e.first_name = ?1",
            nativeQuery = true
    )
    List<Emp> getByFirstName(String firstName);

    @Modifying
    @Query("delete from Employee e where e.id = ?1")
    void deleteById(Long id);


    @Modifying
    @Transactional
    @Query("update Employee e set e.DeptId = :DeptId, e.firstName = :firstName, e.lastName = :lastName where e.id = :id")
    void updateEmp(@Param("emp_firstname") String firstName,
                        @Param("emp_lastname") String lastName,
                        @Param("dept_id") Integer DeptId,
                        @Param("id") long id);




}