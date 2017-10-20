package be.pdp.modelcar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by peterdp on 19.03.17.
 */
@MappedSuperclass
@Getter @Setter
public abstract class DomainObject {

    @Version
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LASTMODIFIED_ON")
    private Date lastModifiedOn;

}