package tacos.web;

import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import tacos.Ingredient;
import tacos.Taco;

import java.util.Date;
import java.util.List;

@Relation(value="taco", collectionRelation="tacos")
public class TacoEntityModel extends RepresentationModel<TacoEntityModel> {
    private static final IngredientEntityModelAssembler
            ingredientAssembler = new IngredientEntityModelAssembler();
    @Getter
    private final String name;
    @Getter
    private final Date createdAt;
    @Getter
    private List<IngredientEntityModel> ingredients;
    public TacoEntityModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients =
                ingredientAssembler.toModels(taco.getIngredients());
    }
}