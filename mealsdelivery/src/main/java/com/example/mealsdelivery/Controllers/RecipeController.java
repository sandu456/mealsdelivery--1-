// package com.example.mealsdelivery.Controllers;
// import com.example.mealsdelivery.Service.RecipeService;
// import com.example.mealsdelivery.models.Recipe;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.IOException;
// import java.util.Optional;

// @RestController
// @RequestMapping("/recipes")
// public class RecipeController {

//     private final RecipeService recipeService;

//     public RecipeController(RecipeService recipeService) {
//         this.recipeService = recipeService;
//     }

//     // ✅ Upload Recipe Card (Only Admins)
//     @PostMapping("/upload")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<String> uploadRecipe(@RequestParam("mealId") String mealId,
//                                                @RequestParam("file") MultipartFile file) {
//         try {
//             String message = recipeService.uploadRecipe(mealId, file);
//             return ResponseEntity.ok(message);
//         } catch (IOException e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload recipe card");
//         }
//     }

//     //Get Recipe Card (For Meal Buyers)
//     // @GetMapping("/{mealId}")
//     // @PreAuthorize("hasRole('ADMIN')")
//     // public ResponseEntity<byte[]> getRecipe(@PathVariable String mealId,@PathVariable String customerId) {
//     //     Optional<Recipe> recipe = recipeService.getRecipe(mealId,customerId);
//     //     return recipe.map(card -> ResponseEntity.ok()
//     //                     .header("Content-Type", "application/pdf")
//     //                     .body(card.getPdfFile().getData()))
//     //             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//     // }
// }
