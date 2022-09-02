package tacos.web;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.Ingredient;
import tacos.Taco;

import java.util.ArrayList;
import java.util.List;

class IngredientEntityModelAssembler extends
        RepresentationModelAssemblerSupport<Ingredient, IngredientEntityModel> {
    public IngredientEntityModelAssembler() {
        super(IngredientController.class, IngredientEntityModel.class);
    }
    @Override
    public IngredientEntityModel toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }
    @Override
    protected IngredientEntityModel instantiateModel(Ingredient ingredient) {
        return new IngredientEntityModel(ingredient);
    }

    public List<IngredientEntityModel> toModels(List<Ingredient> ingredients) {
        List<IngredientEntityModel> ingredientEntityModels = new ArrayList<>();
        ingredients.forEach(this::toModel);
        for (Ingredient ingredient : ingredients) {
            ingredientEntityModels.add(toModel(ingredient));
        }
        return ingredientEntityModels;
    }
}
