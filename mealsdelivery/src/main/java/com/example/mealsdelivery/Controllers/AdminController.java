package com.example.mealsdelivery.Controllers;

import com.example.mealsdelivery.models.Admin;
import com.example.mealsdelivery.Service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

   private final AdminService adminService;

   public AdminController(AdminService adminService) {
       this.adminService = adminService;
   }

   @PostMapping("/register")
   public Admin registerAdmin(@RequestBody Admin admin) {
       return adminService.registerAdmin(admin);
   }

   @GetMapping("/services")
   public String manageServices() {
       return "Admin can handle services here!";
   }

   
}
