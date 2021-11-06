/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.propiedades;

import com.altamira.Globales.AplicacionLogger;
import com.altamira.Globales.ConexionDB;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author leudiswanderbiest
 */
public class Propiedades {

    public enum APLICACION{
        DATOS_LOGS
    }
    
    public enum CONEXION {
        GENERAL_POSTRGRES
    }

    public modAplicacion PropiedadesAplicacion(APLICACION aplicacion){
        InputStream inputSteam = null;
        Properties propBD = new Properties();
        modAplicacion modAplicacion = new modAplicacion();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            inputSteam = classloader.getResourceAsStream("propiedades/Aplicacion.properties");
            propBD.load(inputSteam);
            switch (aplicacion) {
                case DATOS_LOGS:
                    modAplicacion.setLogRuta(propBD.getProperty("logguer.ruta"));
                    modAplicacion.setLogArchivo(propBD.getProperty("logguer.archivo"));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "PropiedadesAplicacion(APLICACION aplicacion)", ex.getMessage());
        }
        return modAplicacion;
    }
    
    public modConexionBD PropiedadesBD(CONEXION tipoPopiedad) {
        InputStream inputSteam = null;
        Properties propBD = new Properties();
        modConexionBD modConexion = new modConexionBD();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            inputSteam = classloader.getResourceAsStream("propiedades/ConexionBD.properties");
            propBD.load(inputSteam);
            switch (tipoPopiedad) {
                case GENERAL_POSTRGRES:
                    modConexion.setJDBC(propBD.getProperty("bd.jdbc"));
                    modConexion.setBD(propBD.getProperty("bd.general"));
                    modConexion.setHOST(propBD.getProperty("host.general"));
                    modConexion.setPUERTO(propBD.getProperty("puerto.general"));
                    modConexion.setUSUARIO(propBD.getProperty("usuario.general"));
                    modConexion.setCLAVE(propBD.getProperty("clave.general"));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "PropiedadesBD(CONEXION tipoPopiedad)", ex.getMessage());
        }
        return modConexion;
    }

    public String obtenerPropiedad(ConexionDB.QUERY_BD queryObtener) {
        InputStream inputSteam = null;
        Properties propBD = new Properties();
        String querySolicitado = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            inputSteam = classloader.getResourceAsStream("propiedades/ConexionBD.properties");
            propBD.load(inputSteam);
            switch (queryObtener) {
                case OBTENER_DESPELGABLES_TODOS:
                    querySolicitado = propBD.getProperty("query.obtenerdesplegables");
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerPropiedad(ConexionDB.QUERY_BD queryObtener)", ex.getMessage());            
        }
        return querySolicitado;
    }
}
