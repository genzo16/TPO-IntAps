package resteasy;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;


@Path("/RSservice")
public class RSservice 
{	
	//- PROCESAR AGENCIA (ACEPTAR O RECHAZAR AGENCIA):
	/*JSON REQUEST (POST):
	Se enviara a la url provista en la solicitud (revisen el JSON anterior).
	{
	 "ID_Solicitud”: "G01_00000045”, 
	 "Estado_Solicitud”: ”APROBADO” 
	}

	(Se espera un mensaje HTTP 200 como respuesta)*/
	@POST
    @Path("/Response")
	@Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response responseMsg( RespuestaJSON  requestBody ) 
	{
		System.out.println(requestBody.Estado_Solicitud);
		System.out.println(requestBody.ID_Solicitud);
        return Response.status(200).build();
        
     // procesar la respuesta
    }
	
	/*
	 * - SOLCITUD AGENCIA.
	 * http://<ip_back_office>:8080/BackOfficeJAXRS/rest/ofertaPaquete/procesarAgencia
	  	{
			 "ID_Hotel”: ”G01_00000067”,
			 "Nombre”: ”Agencia Integracion”,
			 "Direccion”: ”Av. Cordoba 1789”,
			 "Estado_Solicitud”: ”PENDIENTE”,
			 "ID_Solicitud”: "G01_00000045”, 
			 "fecha”:”dd/mm/aaaa”,
			 "url”:”http:desktop-UVjf/api/OfertaHotelera/Response”
		}
	 */
    public void solicitudAgencia( String ip_back_office, SolicitudJSON solicitud) throws Exception 
	{
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("http://"+ip_back_office+":8080/BackOfficeJAXRS/rest/ofertaPaquete/procesarAgencia");

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.json(solicitud));
		try {
			   if (response.getStatus() == 200) 
			      System.out.println("Response: "+response.getStatus());
			   
		} finally {
			  response.close();
		}
    }
    
    // PRUEBA
    /*
    // Para probar solicituAgencia
	@POST
    @Path("/procesarAgencia")
	@Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response procesarAgencia( SolicitudJSON  requestBody ) 
	{
		System.out.println(requestBody.nombre);
		System.out.println(requestBody.estado);
        return Response.status(200).build();
        
     // procesar la respuesta
    }*/
}
