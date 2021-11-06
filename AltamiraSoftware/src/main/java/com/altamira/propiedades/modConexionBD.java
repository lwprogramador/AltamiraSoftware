/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamira.propiedades;

/**
 *
 * @author leudiswanderbiest
 */
public class modConexionBD {

    /**
     * @return the JSDBC
     */
    public String getJDBC() {
        return JDBC;
    }

    /**
     * @param JSDBC the JSDBC to set
     */
    public void setJDBC(String JSDBC) {
        this.JDBC = JSDBC;
    }

    /**
     * @return the BD
     */
    public String getBD() {
        return BD;
    }

    /**
     * @param BD the BD to set
     */
    public void setBD(String BD) {
        this.BD = BD;
    }

    /**
     * @return the HOST
     */
    public String getHOST() {
        return HOST;
    }

    /**
     * @param HOST the HOST to set
     */
    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    /**
     * @return the PUERTO
     */
    public String getPUERTO() {
        return PUERTO;
    }

    /**
     * @param PUERTO the PUERTO to set
     */
    public void setPUERTO(String PUERTO) {
        this.PUERTO = PUERTO;
    }

    /**
     * @return the USUARIO
     */
    public String getUSUARIO() {
        return USUARIO;
    }

    /**
     * @param USUARIO the USUARIO to set
     */
    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    /**
     * @return the CLAVE
     */
    public String getCLAVE() {
        return CLAVE;
    }

    /**
     * @param CLAVE the CLAVE to set
     */
    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }
    
    private String JDBC;
    private String BD;
    private String HOST;
    private String PUERTO;
    private String USUARIO;
    private String CLAVE;
}
