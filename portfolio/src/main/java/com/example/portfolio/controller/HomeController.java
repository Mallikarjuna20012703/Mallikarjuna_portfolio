package com.example.portfolio.controller;



import com.example.portfolio.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Yampalaku Mallikarjuna");
        model.addAttribute("welcomeMessage", "Welcome to My Personal Portfolio Website!");
        return "index"; // will render index.html from templates
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("fullName", "Yampalaku Mallikarjuna");
        model.addAttribute("village", "Kottala palli Villege");
        model.addAttribute("fatherName", "Yampalaku Ramasivudu");
        model.addAttribute("hobbies", "Coding, Reading, Cricket");
        model.addAttribute("bio", "I am a passionate Java Full Stack Developer with a strong interest in building efficient and scalable applications.");
        return "about";
    }


    @GetMapping("/education")
    public String education(Model model) {
        model.addAttribute("tenthSchool", "ZP High School, 2016-2017");
        model.addAttribute("interCollege", "MPC, JC DR College, 2017-2019");
        model.addAttribute("btechCollege", "Sri Krishnadevaraya University College of Engineering and Technology");
        model.addAttribute("branch", "Electronics and Communication Engineering");
        model.addAttribute("yearOfPassing", "2019-2023");
        return "education";
    }
    @GetMapping("/skills")
    public String skills(Model model) {
        model.addAttribute("backendSkills", new String[] {
                "Java", "Spring Boot", "Hibernate", "REST APIs", "JPA"
        });
        model.addAttribute("frontendSkills", new String[] {
                "HTML", "CSS", "JavaScript", "Bootstrap", "Thymeleaf", "React (Basics)"
        });
        model.addAttribute("databaseSkills", new String[] {
                "MySQL", "H2", "JDBC"
        });
        model.addAttribute("toolsSkills", new String[] {
                "IntelliJ IDEA", "Git", "Postman", "Maven"
        });
        return "skills";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", List.of(
                new Project("Reverse Car Parking System", "IoT-based smart vehicle parking using ultrasonic sensors and Arduino.", "C, C++, IDLE, Arduino", "Academic"),
                new Project("WiFi Home Surveillance Camera", "ESP32-CAM based wireless video surveillance project.", "ESP32, Embedded C, WiFi", "Academic"),
                new Project("Student Management System", "A full stack web app to manage students, built using Spring Boot and MySQL.", "Java, Spring Boot, MySQL, Thymeleaf", "Full Stack"),
                new Project("AgroConnect", "Connecting farmers and officers via a digital platform for crop monitoring.", "Spring Boot, React/Thymeleaf, JPA, MySQL", "Major Project")
        ));
        return "projects";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactSubmit(@ModelAttribute("contactForm") ContactForm contactForm, Model model) {
        // For now, just print to console (you can later save to DB or send email)
        System.out.println("Contact Received:");
        System.out.println("Name: " + contactForm.getName());
        System.out.println("Email: " + contactForm.getEmail());
        System.out.println("Message: " + contactForm.getMessage());

        model.addAttribute("success", "Thank you! Your message has been received.");
        return "contact";
    }

    @GetMapping("/resume")
    public String resume()
    {
        return "resume";
    }

    


}
