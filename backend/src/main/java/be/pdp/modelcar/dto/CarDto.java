package be.pdp.modelcar.dto;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Color;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.domain.Scale;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by peterdp on 27/10/2017.
 */
@Getter
@Setter
@ToString(exclude="id")
public class CarDto {

    private Long id;

    private String itemRef;

    private String brandName;

    private String modelType;

    private String modelName;

    private Date productionDate;

    private String color;

    private int limitedEdition;

    private boolean coupe;

    private boolean boxed;

    private String scale;

}
