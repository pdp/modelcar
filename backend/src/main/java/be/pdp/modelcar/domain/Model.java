package be.pdp.modelcar.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static com.google.common.base.Objects.equal;

/**
 * Created by peterdp on 02/10/2017.
 */
@Entity
@Table(name = "Model")
@Getter @Setter
public class Model extends DomainObject{

    @Id
    @SequenceGenerator(name = "MODEL_GEN", sequenceName = "MODEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODEL_GEN")
    private Long id;

    @ManyToOne
    @JoinColumn(name="BRAND_ID")
    private Brand brand;

    private String type;

    private String name;

    private Date productionDate;


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final Model other = (Model) object;
        return equal(type, other.type)
            && equal(name, other.name)
            && equal(productionDate, other.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, name, productionDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("name", name)
                .add("productionDate", productionDate)
                .toString();
    }

}
