package de.unimuenster.pi.library.web.beans;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import de.unimuenster.pi.library.ejb.AgenciaService;
import dtos.AgenciaDTO;

@ManagedBean
public class ListAgencias {
	@EJB
	private AgenciaService ejb;
	
	private Collection<AgenciaDTO> agencias;
	
	public Collection<AgenciaDTO> getAgencias(){
		if(agencias == null)
			agencias = ejb.allAgencias();
		return agencias;
	}
}
