// package com.example.mealsdelivery.Service;
// import com.example.mealsdelivery.models.Customer;
// import com.example.mealsdelivery.models.Recipe;
// import com.example.mealsdelivery.Repository.CustomerRepository;
// import com.example.mealsdelivery.Repository.RecipeRepository;
// import org.springframework.data.mapping.MappingException;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;
// import java.io.IOException;
// import java.util.Optional;

// @Service
// public class RecipeService {

//     private final RecipeRepository recipeRepository;
//     private final EmailService emailService;
//     private final OrderService orderService;
//     private final CustomerRepository customerRepository;

//     public RecipeService(RecipeRepository recipeRepository,EmailService emailService, 
//     OrderService orderService, CustomerRepository customerRepository) {
//         this.recipeRepository = recipeRepository;
//         this.emailService = emailService;
//         this.orderService = orderService;
//         this.customerRepository = customerRepository;
//     }

//     // ✅ Upload Recipe Card
//     public String uploadRecipe(String mealId, MultipartFile file) throws IOException {
//         if (recipeRepository.findByMealId(mealId).isPresent()) {
//             return "A recipe card for this meal already exists!";
//         }

//         Recipe recipe = new Recipe();
//         recipeRepository.save(recipe);
//         return "Recipe card uploaded successfully!";
//     }

//     // ✅ Get Recipe Card
//     public Optional<Recipe> getRecipe(String mealId,String customerId)throws MappingException {
//        // Check if the recipe exists
//         Optional<Recipe> recipe = recipeRepository.findByMealId(mealId);

//         if (recipe.isPresent()) {
//             // Check if the customer has purchased this meal
//             boolean hasPurchased = orderService.hasPurchasedMeal(customerId, mealId);

//             if (hasPurchased) {
//                 // Retrieve customer details and email
//                 Customer customer = customerRepository.findById(customerId)
//                         .orElseThrow(() -> new RuntimeException("Customer not found"));

//                 // Send the recipe card via email
//                 String recipeDetails = "Here is your recipe card for meal ID: " + mealId;
//                 emailService.sendRecipe(customer.getEmail(), recipeDetails);
//             } else {
//                 throw new RuntimeException("Customer has not purchased this meal");
//             }
//         }

//         return recipe;
//     }
// }
