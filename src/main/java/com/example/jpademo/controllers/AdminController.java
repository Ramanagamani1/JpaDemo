package com.example.jpademo.controllers;

import com.example.jpademo.dtos.CreateAdminRequestDto;
import com.example.jpademo.models.Admin;
import com.example.jpademo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody @Valid CreateAdminRequestDto adminRequestDto) {
        adminService.createAdmin(adminRequestDto.to());
    }

    @GetMapping("/admin")
    public List<Admin> getAdmin(){
        return adminService.getAdmin();
    }
}
