package com.aaulaundary.aau_laundary_system.controllers;

import java.util.ArrayList;
import java.util.List;

import com.aaulaundary.aau_laundary_system.Repositories.CampusRepository;
import com.aaulaundary.aau_laundary_system.Services.CampusService;
import com.aaulaundary.aau_laundary_system.Services.ClotheServices;
import com.aaulaundary.aau_laundary_system.Services.RecordService;
import com.aaulaundary.aau_laundary_system.Services.StudentServices;
import com.aaulaundary.aau_laundary_system.models.Campus;
import com.aaulaundary.aau_laundary_system.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    
   

    @Autowired
    private CampusService campusService;
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private ClotheServices clotheServices;
    @Autowired
    private RecordService recordService;

//  public StudentController(CampusService campusService, StudentServices studentServices,
//             ClotheServices clotheServices) {
//         this.campusService = campusService;
//         this.studentServices = studentServices;
//         this.clotheServices = clotheServices;
//     }
    @GetMapping("/sign-up")
    public String signUP(Model model) {
        Student student = new Student();
        List<Campus> campus = campusService.getAllCampus();
        List <String> campusNames = new ArrayList<>();
        for (int i = 0;i<campus.size();i++){
            campusNames.add(campus.get(i).getName());
        }
        System.out.println(campus.get(0).getName());
        model.addAttribute("student", student);
        model.addAttribute("campuses", campusNames);
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String register(@ModelAttribute("student") Student student){
        System.out.println(student);
        String fullName = student.getFirstName()+" "+student.getLastName();
        String id = student.getId();
        String response = recordService.checkIfExists(id, fullName);
        // System.out.println(response);
        if(response.equals("Found")){
            studentServices.saveStudent(student);
            return "home";
        }
        else{

            return "redirect:/sign-up";

        }
        
    }

    
    
    
}
