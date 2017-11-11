package be.pdp.modelcar.domain;

/**
 * Created by peterdp on 03/10/2017.
 */
public enum Scale {

    RATIO_1_18,

    RATIO_1_43;

    public static Scale getScale(String scale) {
        return Scale.valueOf(scale);
    }

}
