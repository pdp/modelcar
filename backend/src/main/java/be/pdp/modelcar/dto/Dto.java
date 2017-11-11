package be.pdp.modelcar.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by peterdp on 02/11/2017.
 */
@Getter @Setter
public abstract class Dto {

    private Long id;

    public boolean isPersisted() {
        return id != null;
    }
}
