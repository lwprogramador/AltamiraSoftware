/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.Globales;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author leudiswanderbiest
 */
public class FechaTiempo {

    public enum SOLO_FECHA {
        OBTENER_AAAA_MM_DD
    }

    public enum FECHA_PARCIAL {
        OBTENER_SOLO_ANO,
        OBTENER_SOLO_MES,
        OBTENER_SOLO_DIA,
    }

    public String obtenerFechaParcial(FECHA_PARCIAL obtener) {
        String fechaReturn = null;
        try {
            Date date = new Date();
            ZoneId timeZone = ZoneId.systemDefault();
            LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
            switch (obtener) {
                case OBTENER_SOLO_ANO:
                    fechaReturn = getLocalDate.getYear() + "";
                    break;
                case OBTENER_SOLO_MES:
                    fechaReturn = getLocalDate.getMonthValue() + "";
                    break;
                case OBTENER_SOLO_DIA:
                    fechaReturn = getLocalDate.getDayOfMonth() + "";
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerFechaParcial(FECHA_PARCIAL obtener)", ex.getMessage());
        }
        return fechaReturn;
    }

    public String obtenerSoloFecha(SOLO_FECHA obtener) {
        String fechaReturn = null;
        try {
            Date date = new Date();
            ZoneId timeZone = ZoneId.systemDefault();
            LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
            switch (obtener) {
                case OBTENER_AAAA_MM_DD:
                    fechaReturn = getLocalDate.getYear() + "-" + getLocalDate.getMonthValue() + "-" + getLocalDate.getDayOfMonth();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerSoloFecha(SOLO_FECHA obtener)", ex.getMessage());
        }
        return fechaReturn;
    }

}
