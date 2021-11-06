/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.Globales;

import com.altamira.Globales.FechaTiempo.SOLO_FECHA;
import com.altamira.propiedades.Propiedades;
import com.altamira.propiedades.Propiedades.APLICACION;
import com.altamira.propiedades.modAplicacion;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author leudiswanderbiest
 */
public class AplicacionLogger {

    Propiedades propAplicacion = new Propiedades();
    FechaTiempo fechaSist = new FechaTiempo();

    Logger loggerArchivo = Logger.getLogger(propAplicacion.PropiedadesAplicacion(APLICACION.DATOS_LOGS).getLogArchivo().replace("@P[FECHA]", fechaSist.obtenerSoloFecha(SOLO_FECHA.OBTENER_AAAA_MM_DD)));
    FileHandler manejadorArchivo;

    public AplicacionLogger(String claseOrigen, String funcion, String mensaje, String sql) {
        try {
            modAplicacion logAplicacion = propAplicacion.PropiedadesAplicacion(APLICACION.DATOS_LOGS);

            Path ubicacionArchivo = Paths.get(logAplicacion.getLogRuta() + logAplicacion.getLogArchivo().replace("@P[FECHA]", fechaSist.obtenerSoloFecha(SOLO_FECHA.OBTENER_AAAA_MM_DD)));

            if (!Files.exists(ubicacionArchivo.getParent())) {
                Files.createDirectory(ubicacionArchivo.getParent());
            }

            manejadorArchivo = new FileHandler(ubicacionArchivo.toString());
            loggerArchivo.addHandler(manejadorArchivo);
            SimpleFormatter formatter = new SimpleFormatter();
            manejadorArchivo.setFormatter(formatter);

            loggerArchivo.info("\n-CLASE DE ORIGEN: " + claseOrigen
                    + "\n" + "-FUNCION DE ORIGEN: " + funcion
                    + "\n" + "-MENSAJE: " + mensaje
                    + "\n" + "-SQL: " + sql
                    + "\n=====================================================================================================================================");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AplicacionLogger(String claseOrigen, String funcion, String mensaje) {
        try {
            modAplicacion logAplicacion = propAplicacion.PropiedadesAplicacion(APLICACION.DATOS_LOGS);

            Path ubicacionArchivo = Paths.get(logAplicacion.getLogRuta() + logAplicacion.getLogArchivo().replace("@P[FECHA]", fechaSist.obtenerSoloFecha(SOLO_FECHA.OBTENER_AAAA_MM_DD)));

            if (!Files.exists(ubicacionArchivo.getParent())) {
                Files.createDirectory(ubicacionArchivo.getParent());
            }

            manejadorArchivo = new FileHandler(ubicacionArchivo.toString());
            loggerArchivo.addHandler(manejadorArchivo);
            SimpleFormatter formatter = new SimpleFormatter();
            manejadorArchivo.setFormatter(formatter);

            loggerArchivo.info("-CLASE DE ORIGEN: " + claseOrigen + "\n" + "-FUNCION DE ORIGEN: " + funcion + "\n" + "-MENSAJE: " + mensaje);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
