package com.ceiba.licorera.dominio.validador;

import com.ceiba.licorera.dominio.excepcion.ExcepcionFecha;
import com.ceiba.licorera.dominio.excepcion.ExcepcionHora;
import com.ceiba.licorera.dominio.excepcion.ExcepcionValorObligatorio;

import java.util.Calendar;
import java.util.Date;

public final class ValidadorDeArgumento {
    private ValidadorDeArgumento() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            {
                throw new ExcepcionValorObligatorio(mensaje);
            }
        }
    }

    public static void validarFecha(Date fecha, String mensaje) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int diaDomingo = calendar.get(Calendar.DAY_OF_WEEK);
        if (diaDomingo == Calendar.SUNDAY) {
            throw new ExcepcionFecha(mensaje);
        }
    }

    public static void valiarhora(int hora, String mensaje) {
        if (hora < 11) {
            throw new ExcepcionHora(mensaje);
        }
    }
}
