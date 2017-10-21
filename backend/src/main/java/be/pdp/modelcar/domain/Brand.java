package be.pdp.modelcar.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by peterdp on 02/10/2017.
 */
@Entity
@Table(name = "Brand")
@Getter @Setter
@ToString(exclude="id")
public class Brand extends DomainObject{

    @Id
    @SequenceGenerator(name = "BRAND_GEN", sequenceName = "BRAND_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_GEN")
    private Long id;

    private String name;

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final Brand other = (Brand) object;
        return Objects.equal(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
