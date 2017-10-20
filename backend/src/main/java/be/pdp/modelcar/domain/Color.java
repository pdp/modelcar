package be.pdp.modelcar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by peterdp on 03/10/2017.
 */
@Entity
@Table(name = "Color")
@Getter @Setter
public class Color extends DomainObject{

    private String name;

    @Id
    @SequenceGenerator(name = "COLOR_GEN", sequenceName = "COLOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLOR_GEN")
    private Long id;
}
