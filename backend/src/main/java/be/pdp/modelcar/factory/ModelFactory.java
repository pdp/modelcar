package be.pdp.modelcar.factory;

import be.pdp.modelcar.backend.BrandRepository;
import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.ModelDto;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ModelFactory {

    public Model createModel(ModelDto modelDto) {
        Model model = new Model();
        model.setName(modelDto.getName());
        model.setProductionDate(modelDto.getProductionDate());
        model.setType(modelDto.getType());
        return model;
    }
}
