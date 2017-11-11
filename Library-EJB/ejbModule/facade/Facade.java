package facade;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dtos.SolicitudDTO;
import sessionBeans.AdministrarAgencias;

/**
 * Session Bean implementation class Facade
 */
@Singleton
@LocalBean
public class Facade implements FacadeRemote,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	AdministrarAgencias admAgencia;
	
    public Facade() {
    }
    
	public void validarAgencia(SolicitudDTO dto) {
		admAgencia.validarAgencia(dto);
	}
	
}
