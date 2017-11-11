package resteasy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;

public class TestServiciosRest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	/*	URL url = new URL("http://localhost:8080/Library-Web/rest/RSservice/Response");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "application/json");
		IOUtils.write("{\"ID_Solicitud\": \"G01_00000045\", \"Estado_Solicitud\": \"APROBADO\" }", urlConnection.getOutputStream());	 
		
		if(urlConnection.getResponseCode() != 200) {
				throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
			}
		System.out.println("Codigo de respuesta: " + urlConnection.getResponseCode());*/
	//	String response = IOUtils.toString(urlConnection.getInputStream());
	//	System.out.println("Respuesta: " + response);
		
		SolicitudJSON solicitud = new SolicitudJSON();
		solicitud.estado ="PENDIENTE";
		solicitud.nombre="Hotel de pruebas";
		Client client = ClientBuilder.newClient();
   // 	WebTarget target = client.target("http://"+ip_back_office+":8080/BackOfficeJAXRS/rest/ofertaPaquete/procesarAgencia");
    	WebTarget target = client.target("http://localhost:8080/Library-Web/rest/RSservice/procesarAgencia");
    	
    	
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.json(solicitud));
		try {
			   if (response.getStatus() == 200) 
			      System.out.println("Response: "+response.getStatus());
			   
		} finally {
			  response.close();
		}

	}

}
