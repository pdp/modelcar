package be.pdp.modelcar.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by peterdp on 03/10/2017.
 */
@Entity
@Table(name = "Color")
@Getter @Setter
@ToString(exclude="id")
public class Color extends DomainObject{

    @Id
    @SequenceGenerator(name = "COLOR_GEN", sequenceName = "COLOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLOR_GEN")
    private Long id;

    private String name;

}
