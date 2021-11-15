package com.keying.antra.restAPI.Service;

import com.keying.antra.restAPI.DAO.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

//service存在于C层和D层之间
@Service
public interface DeptService {

    List<Department> getAllDept();

    Department getDeptById(Integer Id);


}
