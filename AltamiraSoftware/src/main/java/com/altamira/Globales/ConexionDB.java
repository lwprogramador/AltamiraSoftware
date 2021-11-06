/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.Globales;

import com.altamira.propiedades.Propiedades;
import com.altamira.propiedades.Propiedades.CONEXION;
import com.altamira.propiedades.modConexionBD;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.Json;

/**
 *
 * @author leudiswanderbiest
 */
public class ConexionDB {

    private final Propiedades propSistema = new Propiedades();
    private Connection conexionSQL = null;
    private final int TIEMPO_VALIDACION = 3;

    private void ConexionDB(TIPO_CONEXION _tipoBD) {
        try {
            switch (_tipoBD) {
                case BD_GENERAL_POSTGRES:
                    modConexionBD propBD = propSistema.PropiedadesBD(CONEXION.GENERAL_POSTRGRES);
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        new AplicacionLogger(this.getClass().toString(), "Class.forName(\"org.postgresql.Driver\")", ex.getMessage());
                    }
                    conexionSQL = DriverManager.getConnection(
                            propBD.getJDBC() + "://" + propBD.getHOST() + ":" + propBD.getPUERTO() + "/" + propBD.getBD(),
                            propBD.getUSUARIO(), propBD.getCLAVE());
                default:
                    break;
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "ConexionDB(TIPO_CONEXION _tipoBD)", ex.getMessage());            
        }
    }

    private String crearSQL(String sql, Map<String, String> parametros) {
        try {
            for (Map.Entry<String, String> param : parametros.entrySet()) {
                sql = sql.replaceAll("@P\\[" + param.getKey() + "]", param.getValue());
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "rearSQL(String sql, Map<String, String> parametros)", ex.getMessage());                        
        }
        return sql;
    }

    public JsonArray obtenerData(TIPO_CONEXION conexion, String queryEjecutar, Map<String, String> parametros) {
        JsonArray datosObtenidos = null;
        JsonReader lectorJSON = null;
        ResultSet resultSet = null;
        Statement statEjecutar = null;
        try {
            if (conexionSQL == null || !conexionSQL.isValid(TIEMPO_VALIDACION)) {
                ConexionDB(conexion);
            }
            if (conexionSQL.isValid(TIEMPO_VALIDACION)) {
                queryEjecutar = crearSQL(queryEjecutar, parametros);
                statEjecutar = conexionSQL.createStatement();
                resultSet = statEjecutar.executeQuery(queryEjecutar);
                if (resultSet != null) {
                    if (resultSet.next()) {
                        lectorJSON = Json.createReader(new StringReader(resultSet.getString(1)));
                        datosObtenidos = lectorJSON.readArray();
                    }
                }
            }
        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerData(TIPO_CONEXION conexion, String queryEjecutar, Map<String, String> parametros)", ex.getMessage(), queryEjecutar);            
        } finally {
            if (lectorJSON != null) {
                lectorJSON.close();
            }
            try {
                if (statEjecutar != null && !statEjecutar.isClosed()) {
                    statEjecutar.close();
                }
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (conexionSQL != null && !conexionSQL.isClosed()) {
                    conexionSQL.close();

                }
            } catch (SQLException exSQL) {
                new AplicacionLogger(this.getClass().toString(), "obtenerData --> catch --> finally", exSQL.getMessage(), queryEjecutar);
            }
        }
        return datosObtenidos;
    }

    public JsonArray obtenerData(TIPO_CONEXION conexion, String queryEjecutar) {
        JsonArray datosObtenidos = null;
        JsonReader lectorJSON = null;
        ResultSet resultSet = null;
        Statement statEjecutar = null;
        try {
            if (conexionSQL == null || !conexionSQL.isValid(TIEMPO_VALIDACION)) {
                ConexionDB(conexion);
            }
            if (conexionSQL.isValid(TIEMPO_VALIDACION)) {
                statEjecutar = conexionSQL.createStatement();
                resultSet = statEjecutar.executeQuery(queryEjecutar);
                if (resultSet != null) {
                    if (resultSet.next()) {
                        lectorJSON = Json.createReader(new StringReader(resultSet.getString(1)));
                        datosObtenidos = lectorJSON.readArray();
                    }
                }
            }
        } catch (SQLException ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerData(TIPO_CONEXION conexion, String queryEjecutar)", ex.getMessage(), queryEjecutar);            
        } finally {
            if (lectorJSON != null) {
                lectorJSON.close();
            }
            try {
                if (statEjecutar != null && !statEjecutar.isClosed()) {
                    statEjecutar.close();
                }
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (conexionSQL != null && !conexionSQL.isClosed()) {
                    conexionSQL.close();
                }
            } catch (SQLException ex) {
                new AplicacionLogger(this.getClass().toString(), "obtenerData(TIPO_CONEXION conexion, String queryEjecutar) --> finally --> catch()", ex.getMessage(), queryEjecutar);            
            }
        }
        return datosObtenidos;
    }

    public enum TIPO_CONEXION {
        BD_GENERAL_POSTGRES
    }

    public enum QUERY_BD {
        OBTENER_DESPELGABLES_TODOS
    }

}
