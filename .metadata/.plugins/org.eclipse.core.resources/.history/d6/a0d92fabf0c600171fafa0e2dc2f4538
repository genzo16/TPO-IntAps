package de.unimuenster.pi.library.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

import de.unimuenster.pi.library.jpa.Agencia;
import dtos.AgenciaDTO;

@Remote
public interface AgenciaService {
	
	public Agencia crearAgencia(String nombre, String direccion);
	public Agencia crearAgencia(Agencia agencia) throws Exception;
	public Response validacionAgencia(AgenciaDTO agencia);
	public List<AgenciaDTO> allAgencias();
	Agencia getAgencia(int agenciaID);
}
