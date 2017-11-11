package be.pdp.modelcar.dto;

import be.pdp.modelcar.domain.DomainObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by peterdp on 03/10/2017.
 */
@Getter @Setter
public class ColorDto extends Dto{

    private String name;

}
