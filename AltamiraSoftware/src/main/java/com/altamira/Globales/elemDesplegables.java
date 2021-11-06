/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.Globales;

import com.altamira.propiedades.Propiedades;
import com.altamira.Globales.ConexionDB.QUERY_BD;
import com.altamira.Globales.ConexionDB.TIPO_CONEXION;
import javax.json.JsonArray;

/**
 *
 * @author leudiswanderbiest
 */
public class elemDesplegables {

    Propiedades propSQL = new Propiedades();

    public JsonArray obtenerDesplegable() {
        JsonArray returnDesplegable = null;
        try {
            String consultaEjecutar = propSQL.obtenerPropiedad(QUERY_BD.OBTENER_DESPELGABLES_TODOS);
            ConexionDB conexionSQL = new ConexionDB();
            returnDesplegable = conexionSQL.obtenerData(TIPO_CONEXION.BD_GENERAL_POSTGRES, consultaEjecutar);
            /*for (int i = 0; i < jsonItems.size(); ++i) {
                JsonObject rec = jsonItems.getJsonObject(i);
                String id = rec.getString("texto");
                String loc = rec.get("unico").toString();
                System.out.println(id + " - " + loc);
            }*/

        } catch (Exception ex) {
            new AplicacionLogger(this.getClass().toString(), "obtenerDesplegable()", ex.getMessage());
        }
        return returnDesplegable;
    }
}
