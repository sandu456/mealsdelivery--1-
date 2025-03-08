package com.example.mealsdelivery.Service;

import com.example.mealsdelivery.models.Admin;
import com.example.mealsdelivery.Repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin registerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");
        return adminRepository.save(admin);
    }

    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found with username: " + username));

        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .roles(admin.getRole()) // Assumes role is a String like "ADMIN"
                .build();
    }

    
}
