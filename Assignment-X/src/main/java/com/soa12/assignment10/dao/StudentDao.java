package com.soa12.assignment10.dao;

import com.soa12.assignment10.model.StudentEntity;

public interface StudentDao {
    public StudentEntity getStudent(String email);

    public void save(StudentEntity student);

    public void update(StudentEntity student);

    public void delete(StudentEntity student);
}
