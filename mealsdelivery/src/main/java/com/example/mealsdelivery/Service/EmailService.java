// package com.example.mealsdelivery.Service;
// import com.example.mealsdelivery.Repository.CustomerRepository;
// import com.example.mealsdelivery.models.Customer;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mapping.MappingException;
// import org.springframework.mail.MailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// public class EmailService {

//     @Autowired
//     private JavaMailSender javaMailSender;

//     @Autowired
//     private CustomerRepository customerRepository;

//     // Method to send recipe card to the customer
//     public void sendRecipe(String customerId, String recipeDetails) throws MappingException {
//         // Retrieve the customer's email from the database
//         Optional<Customer> customerOpt = customerRepository.findById(customerId);
        
//         if (!customerOpt.isPresent()) {
//             throw new RuntimeException("Customer not found with ID: " + customerId);
//         }

//         Customer customer = customerOpt.get();

//         // Create a MimeMessage for the email
//     //     MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//     //     MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true); // 'true' means multipart

//     //     // Set the email properties
//     //     messageHelper.setFrom("sadupama456@gmail.com"); // You can still set this as a fixed sender if needed
//     //     messageHelper.setTo(customer.getEmail()); // Automatically send to the customer's email
//     //     messageHelper.setSubject("Your Requested Recipe Card");
//     //     messageHelper.setText(recipeDetails); // Recipe details (can be PDF or plain text)

//     //     // Send the email
//     //     javaMailSender.send(mimeMessage);
//      }
// }
