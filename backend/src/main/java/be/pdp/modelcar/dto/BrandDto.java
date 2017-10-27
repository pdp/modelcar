package be.pdp.modelcar.dto;

import be.pdp.modelcar.domain.DomainObject;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by peterdp on 02/10/2017.
 */
@Getter @Setter
public class BrandDto {

    private Long id;

    private String name;

}
