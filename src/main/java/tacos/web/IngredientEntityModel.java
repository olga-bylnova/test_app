package tacos.web;

import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import tacos.Ingredient;

public class IngredientEntityModel extends RepresentationModel<IngredientEntityModel> {
    @Getter
    private String name;
    @Getter
    private Ingredient.Type type;
    public IngredientEntityModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}