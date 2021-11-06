/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.altamira.endpoint;

import com.altamira.Globales.elemDesplegables;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author leudiswanderbiest
 */
@Path("obtener")
@RequestScoped
public class Obtener {

    @GET
    @Path("desplegables")
    @Produces(MediaType.APPLICATION_JSON)
    public Response desplegables() {
        try {
            elemDesplegables el = new elemDesplegables();
            return Response.status(Response.Status.ACCEPTED).entity(el.obtenerDesplegable()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El servidor no pudo interpretar la solicitud dada una sintaxis inválida").build();
        }
    }
}
