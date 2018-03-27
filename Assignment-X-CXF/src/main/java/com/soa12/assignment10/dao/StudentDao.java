package com.soa12.assignment10.dao;

import com.soa12.assignment10.model.StudentsEntity;

public interface StudentDao {
    public StudentsEntity getStudent(int id);

    public void save(StudentsEntity student);

    public void update(StudentsEntity student);

    public void delete(StudentsEntity student);
}
