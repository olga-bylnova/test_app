package tacos.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tacos.Ingredient;

import java.util.List;
@Configuration
public class IngredientConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            IngredientRepository ingredientRepository
    ) {
        return args -> ingredientRepository.saveAll(List.of(
                new Ingredient("Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("Salsa", Ingredient.Type.SAUCE),
                new Ingredient("Sour Cream", Ingredient.Type.SAUCE)
        ));
    }
}
