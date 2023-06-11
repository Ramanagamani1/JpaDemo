package com.example.jpademo.services;

import com.example.jpademo.models.Admin;
import com.example.jpademo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }
}
