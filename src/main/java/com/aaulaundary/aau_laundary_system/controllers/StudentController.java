package com.aaulaundary.aau_laundary_system.controllers;

import java.util.ArrayList;
import java.util.List;

import com.aaulaundary.aau_laundary_system.Repositories.CampusRepository;
import com.aaulaundary.aau_laundary_system.Services.CampusService;
import com.aaulaundary.aau_laundary_system.Services.ClotheServices;
import com.aaulaundary.aau_laundary_system.Services.RecordService;
import com.aaulaundary.aau_laundary_system.Services.UserServices;
import com.aaulaundary.aau_laundary_system.models.Campus;
import com.aaulaundary.aau_laundary_system.models.User;

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
    private UserServices studentServices;
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


@GetMapping("/")
public String home(Model model) {

    return "home";
}

@GetMapping("/login")
public String login(Model model) {

    return "login";
}
    @GetMapping("/sign-up")
    public String signUP(Model model) {
        User student = new User();
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
    public String register(@ModelAttribute("student") User student){
        System.out.println(student);
        String fullName = student.getFirstName()+" "+student.getLastName();
        String studentId = student.getUsername();
        String response = recordService.checkIfExists(studentId, fullName);
        boolean alreadyExists = studentServices.findUser(student.getUsername())!=null;
        // System.out.println(response);
        // System.out.println(alreadyExists);
        if(response.equals("Found") && !alreadyExists){
            studentServices.saveUser(student);
            return "home";
        }
        else{
            return "faultySignup";
        }
        
        
    }
    

    
    
    
}
