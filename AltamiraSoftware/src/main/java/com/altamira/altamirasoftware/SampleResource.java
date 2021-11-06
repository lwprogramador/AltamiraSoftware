package com.altamira.altamirasoftware;

import com.altamira.Globales.ConexionDB;
import com.altamira.Globales.ConexionDB.TIPO_CONEXION;
import com.altamira.Globales.ConexionDB.QUERY_BD;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("sample")
public class SampleResource {

	@Inject
	@ConfigProperty(name = "message")
	private String message;

	@GET
	public Response message() {
            System.out.println("Message: " + message);
            ConexionDB con = new ConexionDB();
            //JsonArray resp = con.obtenerData(TIPO_CONEXION.BD_POSTGRES, );
		return Response.ok("").build();
	}

}
