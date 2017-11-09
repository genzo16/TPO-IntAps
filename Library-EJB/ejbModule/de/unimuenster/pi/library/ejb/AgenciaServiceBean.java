package de.unimuenster.pi.library.ejb;

import java.util.Collection;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


import de.unimuenster.pi.library.jpa.Agencia;
import dtos.AgenciaDTO;

/**
 * Session Bean implementation class BookService.
 * 
 * Also provides an exemplary web service with two operations.
 * @author Henning Heitkoetter
 */
@Stateless
@WebService(name = "AgenciaWebService", serviceName = "AgenciaService", portName = "AgenciaServicePort")
public class AgenciaServiceBean implements AgenciaService {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Agencia crearAgencia(@WebParam(name = "nombre") String nombre,
			@WebParam(name = "direccion") String direccion) {
		Agencia newAgencia = new Agencia(nombre,direccion);	
		return crearAgencia(newAgencia);
	}

	@Override
	@WebMethod(exclude = true)
	public Agencia crearAgencia(Agencia agencia) {
		if (em.createQuery("SELECT COUNT(*) FROM Agencia WHERE nombre=:nombre", Long.class).setParameter("nombre", agencia.getNombre())
				.getSingleResult() > 0)
			throw new EJBException(new ConstraintViolationException(
					"La Agencia ya existe", null));

		em.persist(agencia);
		return agencia;
	}

	@Override
	public Agencia getAgencia(int agenciaID) {
		Agencia agencia = em.find(Agencia.class, agenciaID);
		if (agencia == null)
			throw new IllegalArgumentException(String.format(
					"Agencia con ID %s no encontrada", agenciaID));
		return agencia;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Collection<Agencia> getAllAgencias() {
		return em.createQuery("FROM Agencia", Agencia.class).getResultList();
	}
	
	private void sendPostToBackOffice(AgenciaDTO agencia) throws Exception {
		String URI_BOOK = "http://localhost:8080/WebApp/REST/agencias/read"; //Cambiar URL
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(URI_BOOK).request().post(Entity.entity(agencia, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if(status != 200) {
			throw new Exception("No llegó un 200 a respuesta del POST.");
		}
	}
}
