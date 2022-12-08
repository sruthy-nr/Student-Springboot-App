package com.nest.studentapp_backend.dao;

import com.nest.studentapp_backend.model.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Students,Integer> {

    @Query(value = "SELECT `id`, `admno`, `college`, `name`, `rollno` FROM `students` WHERE `admno`=:admno",nativeQuery = true)
    public List<Students> searchStudent(@Param("admno") String admno);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `students` WHERE `id`=:id",nativeQuery = true)
    public void deleteStudent(@Param("id") Integer id);
}
