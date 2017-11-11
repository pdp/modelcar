package be.pdp.modelcar.dto;

import be.pdp.modelcar.domain.DomainObject;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

import static com.google.common.base.Objects.equal;

/**
 * Created by peterdp on 02/10/2017.
 */
@Getter @Setter
public class ModelDto extends Dto {

    private BrandDto brandDto;

    private String type;

    private String name;

    private Date productionDate;

}
