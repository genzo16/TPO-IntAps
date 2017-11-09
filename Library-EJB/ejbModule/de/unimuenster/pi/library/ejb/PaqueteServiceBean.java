package de.unimuenster.pi.library.ejb;

import java.util.Collection;
import java.util.Date;

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
import de.unimuenster.pi.library.jpa.Paquete;
import dtos.AgenciaDTO;

@Stateless
@WebService(name = "PaqueteWebService", serviceName = "PaqueteService", portName = "PaqueteServicePort")
public class PaqueteServiceBean implements PaqueteService {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Paquete crearPaquete(@WebParam(name = "nombre") String nombre,
			@WebParam(name = "descripcion") String descripcion, 
			@WebParam(name = "fechaDesde") Date fechaDesde,
			@WebParam(name = "fechaHasta") Date fechaHasta,
			@WebParam(name = "agencia") String agencia,
			@WebParam(name = "destino") String destino,
			@WebParam(name = "estado") String estado,
			@WebParam(name = "cupo") int cupo){
		Paquete newPaquete = new Paquete(nombre,descripcion,fechaDesde,fechaHasta,agencia,destino,estado,cupo);	
		return crearPaquete(newPaquete);
	}

	@Override
	@WebMethod(exclude = true)
	public Paquete crearPaquete(Paquete newPaquete) {
		if (em.createQuery("SELECT COUNT(*) FROM Agencia WHERE nombre=:nombre", Long.class).setParameter("nombre", newPaquete.getNombre())
				.getSingleResult() > 0)
			throw new EJBException(new ConstraintViolationException(
					"La Agencia ya existe", null));

		em.persist(newPaquete);
		return newPaquete;
	}

	@Override
	public Paquete getPaquete(int paqueteId) {
		Paquete paquete = em.find(Paquete.class, paqueteId);
		if (paquete == null)
			throw new IllegalArgumentException(String.format(
					"Agencia con ID %s no encontrada", paqueteId));
		return paquete;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Collection<Paquete> getAllPaquetes() {
		return em.createQuery("FROM Paquete", Paquete.class).getResultList();
	}
	
	private void sendPostToBackOffice(AgenciaDTO agencia) throws Exception {
		String URI_BOOK = "http://localhost:8080/WebApp/REST/paquetes/read"; //Cambiar URL
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(URI_BOOK).request().post(Entity.entity(agencia, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if(status != 200) {
			throw new Exception("No llegó un 200 a respuesta del POST.");
		}
	}
}
