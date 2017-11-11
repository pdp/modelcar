package be.pdp.modelcar.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by peterdp on 02/10/2017.
 */
@Entity
@Table(name = "Car")
@Getter @Setter
@ToString(exclude="id")
public class Car extends DomainObject {

    @Id
    @SequenceGenerator(name = "CAR_GEN", sequenceName = "CAR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_GEN")
    private Long id;

    private String itemRef;

    @ManyToOne
    @JoinColumn(name="MODEL_ID")
    private Model model;

    @ManyToOne
    @JoinColumn(name="COLOR_ID")
    private Color color;

    @Column(name = "LIMITED_EDITION")
    private int limitedEdition;

    private boolean coupe;

    private boolean boxed;

    @Enumerated(EnumType.STRING)
    private Scale scale;


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final Car other = (Car) object;
        return Objects.equal(itemRef, other.itemRef);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemRef);
    }

}
