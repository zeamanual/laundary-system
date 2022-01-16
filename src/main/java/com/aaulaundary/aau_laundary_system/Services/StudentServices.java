package com.aaulaundary.aau_laundary_system.Services;

import java.util.List;

import com.aaulaundary.aau_laundary_system.models.Student;




public interface StudentServices {

    public Student saveStudent(Student student);
    public void updateStudent(String id, Student student);
    public Student findStudent(String id);
    public void deleteStudent(String id);
    public List<Student> findAllStudent();
    public void deleteAllStudent();

    
}
