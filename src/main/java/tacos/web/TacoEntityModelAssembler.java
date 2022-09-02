package tacos.web;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.Taco;

import java.util.ArrayList;
import java.util.List;

public class TacoEntityModelAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoEntityModel> {
    public TacoEntityModelAssembler() {
        super(DesignTacoController.class, TacoEntityModel.class);
    }
    @Override
    protected TacoEntityModel instantiateModel(Taco taco) {
        return new TacoEntityModel(taco);
    }
    @Override
    public TacoEntityModel toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }

    public List<TacoEntityModel> toModels(List<Taco> tacos) {
        List<TacoEntityModel> tacoEntityModels = new ArrayList<>();
        tacos.forEach(this::toModel);
        for (Taco taco : tacos) {
            tacoEntityModels.add(toModel(taco));
        }
        return tacoEntityModels;
    }
}