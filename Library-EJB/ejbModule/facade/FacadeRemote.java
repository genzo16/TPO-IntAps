package facade;

import javax.ejb.Remote;

import dtos.SolicitudDTO;

@Remote
public interface FacadeRemote {
	
	public void validarAgencia(SolicitudDTO solicitud);
}
