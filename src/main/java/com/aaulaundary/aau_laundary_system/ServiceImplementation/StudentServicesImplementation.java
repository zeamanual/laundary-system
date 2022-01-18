package com.aaulaundary.aau_laundary_system.ServiceImplementation;

import java.util.List;

import com.aaulaundary.aau_laundary_system.Repositories.StudentRepository;
import com.aaulaundary.aau_laundary_system.Services.StudentServices;
import com.aaulaundary.aau_laundary_system.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentServicesImplementation implements StudentServices {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(String id, Student student) {

        if (studentRepository.existsById(id)){
            studentRepository.save(student); 
        }  
    }

    @Override
    public Student findStudent(String id) {
        if (studentRepository.existsById(id)){
             return studentRepository.findById(id).get();
        }
        return null;
       
    }

   
    @Override
    public void deleteStudent(String id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
      
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteAllStudent() {
        studentRepository.deleteAll();
        
    }

    
}
