package com.zeggs.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Brian
 */
public abstract class ServicioGenerico {

    public Integer haciaBaseDatosBoolean(Boolean booleano) {
        if (booleano != null) {
            return (booleano) ? 1 : 0;
        }
        return null;
    }

    public Boolean convertirBoolean(Object bigDecimal) {
        if (bigDecimal != null) {
            return ((BigDecimal) bigDecimal).intValue() == 1;
        }
        return null;
    }

    public Integer convertirInteger(Object bigDecimal) {
        if (bigDecimal != null) {
            return ((Integer) bigDecimal);
        }
        return null;
    }

    public Long convertirLong(Object bigDecimal) {
        if (bigDecimal != null) {
            return ((Long) bigDecimal);
        }
        return null;
    }

    public Float convertirFloat(Object bigDecimal) {
        if (bigDecimal != null) {
            return ((BigDecimal) bigDecimal).floatValue();
        }
        return null;
    }

    public Double convertirDouble(Object bigDecimal) {
        if (bigDecimal != null) {
            return ((BigDecimal) bigDecimal).doubleValue();
        }
        return null;
    }

    public Date convertirDate(Object date) {

        if (date != null) {
            return (Date) date;
        }

        return null;
    }

    public String convertirString(Object string) {
        if (string != null) {
            return (String) string;
        }
        return null;
    }
}
