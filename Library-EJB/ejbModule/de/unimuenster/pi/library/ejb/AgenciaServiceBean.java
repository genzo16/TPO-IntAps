package de.unimuenster.pi.library.ejb;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


import de.unimuenster.pi.library.jpa.Agencia;
import dtos.AgenciaDTO;
import enums.EstadoAgencia;

@Stateless
@LocalBean
@Path("agencias")
@WebService(name = "AgenciaWebService", serviceName = "AgenciaService", portName = "AgenciaServicePort")
public class AgenciaServiceBean implements AgenciaService {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Agencia crearAgencia(@PathParam("nombre") String nombre, @PathParam("direccion") String direccion) {
		Agencia agencia = buscarAgencia(nombre);
		if (agencia == null) {
			try {
				agencia = new Agencia(nombre, direccion);
				manager.persist(agencia);
				//sendPostToBackOffice(agencia.toDTO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return agencia;
	}
	
	/*@POST
	@Path("/{nombre}/{direccion}")
	public Agencia crearAgencia(Agencia agencia) throws Exception {
		if (manager.createQuery("SELECT COUNT(*) FROM Agencia WHERE nombre=:nombre", Long.class).setParameter("nombre", agencia.getNombre())
				.getSingleResult() > 0)
			throw new EJBException(new ConstraintViolationException(
					"La Agencia ya existe", null));
		
		//sendPostToBackOffice(agencia.toDTO());
		manager.persist(agencia);
		return agencia;
	}*/
	
	@Override
	@WebMethod(exclude = true)
	public Agencia crearAgencia(Agencia agencia) throws Exception {
		if (manager.createQuery("SELECT COUNT(*) FROM Agencia WHERE nombre=:nombre", Long.class).setParameter("nombre", agencia.getNombre())
				.getSingleResult() > 0)
			throw new EJBException(new ConstraintViolationException(
					"La Agencia ya existe", null));
		agencia.setEstado(EstadoAgencia.PENDIENTE_DE_ACTIVACION);
		manager.persist(agencia);
		//sendPostToBackOffice(agencia.toDTO());
		return agencia;
	}
	
	private void sendPostToBackOffice(AgenciaDTO agencia) {
		try{
		URL url = new URL("http://192.168.0.102:8080/BackOfficeJAXRS/rest/ofertaPaquete/solicitudAgencia"); //Cambiar URL
		/*ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(URI_BOOK).request().post(Entity.entity(agencia, MediaType.APPLICATION_JSON));
		}*/
		HttpURLConnection urlConnection = (HttpURLConnection)
		url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "application/json");
		IOUtils.write("Hola Probando", urlConnection.getOutputStream());
		if(urlConnection.getResponseCode() != 200)
			throw new RuntimeException("Error de conexion"+ urlConnection.getResponseCode());
		
		String response = IOUtils.toString(urlConnection.getInputStream());
		System.out.println("Respuesta POST: "+ response);
		}catch(Exception e){
			
		}
	}

	private Agencia buscarAgencia(String nombre) {
		Agencia agencia = null;
		try {
			agencia = (Agencia) manager.createQuery("FROM Agencia WHERE nombre = :nombre")
					.setParameter("nombre", nombre).getSingleResult();
		} catch (NoResultException e) {

		}
		return agencia;
	}

	@POST
	@Path("/validacionAgencia")
	@Consumes("application/json")
	public Response validacionAgencia(AgenciaDTO agencia) {
		Agencia a = new Agencia(agencia.getIdAgencia(),agencia.getNombre(),agencia.getDireccion(),EstadoAgencia.ACTIVA);
		manager.merge(a);
		return Response.status(Response.Status.OK).entity("Mensjae Recibido").build();
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/All")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AgenciaDTO> allAgencias() {
		List<Agencia> agencias = new ArrayList<>();
		List<AgenciaDTO> agenciasDto = new ArrayList<>();
		try {
			agencias = (List<Agencia>) manager.createQuery("from Agencia").getResultList();
			for (Agencia a : agencias) {
				AgenciaDTO aux = null;
				aux.setDireccion(a.getDireccion());
				aux.setEstado(a.getEstado().toString());
				aux.setIdAgencia(a.getIdAgencia());
				aux.setMail(a.getMail());
				aux.setNombre(a.getNombre());
				agenciasDto.add(aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return agenciasDto;
	}
	@Override
	public Agencia getAgencia(int agenciaID) {
		Agencia agencia = manager.find(Agencia.class, agenciaID);
		if (agencia == null)
			throw new IllegalArgumentException(String.format(
					"Agencia con ID %s no encontrada", agenciaID));
		return agencia;
	}
	
}
