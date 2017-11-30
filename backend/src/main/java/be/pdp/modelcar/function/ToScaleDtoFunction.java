package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Scale;
import be.pdp.modelcar.dto.ScaleDto;
import com.google.common.base.Function;
import org.springframework.stereotype.Component;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ToScaleDtoFunction implements Function<Scale, ScaleDto> {

    @Override
    public ScaleDto apply(Scale scale) {
        ScaleDto dto = new ScaleDto();
        dto.setName(scale.name());
        return dto;
    }
}
