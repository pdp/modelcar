package be.pdp.modelcar.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by peterdp on 27/10/2017.
 */
@Getter @Setter
public class CarDto extends Dto {

    private String itemRef;

    private ModelDto modelDto;

    private ColorDto colorDto;

    private int limitedEdition;

    private boolean coupe;

    private boolean boxed;

    private ScaleDto scale;


}
