package be.pdp.modelcar.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by peterdp on 27/10/2017.
 */
@Getter
@Setter
public class CarDto {

    private Long id;

    private String itemRef;

    private BrandDto brandDto;

    private ModelDto modelDto;

    private ColorDto colorDto;

    private int limitedEdition;

    private boolean coupe;

    private boolean boxed;

    private Scale scale;


}
