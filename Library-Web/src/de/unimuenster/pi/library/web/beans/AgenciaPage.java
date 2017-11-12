package de.unimuenster.pi.library.web.beans;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import de.unimuenster.pi.library.ejb.AgenciaService;
import de.unimuenster.pi.library.jpa.Agencia;
import de.unimuenster.pi.library.web.Util;

@ManagedBean
@ViewScoped
public class AgenciaPage {
	@EJB
	private AgenciaService agenciaEjb;
	
	private int agenciaID;
	private Agencia agencia;

	public void ensureInitialized() {
		try{
			if(getAgencia() != null)
				// Success
				return;
		} catch(EJBException e) {
			e.printStackTrace();
		}
		Util.redirectToRoot();
	}
	
	public int getAgenciaId() {
		return agenciaID;
	}

	public void setAgenciaId(int agenciaID) {
		this.agenciaID = agenciaID;
		agencia = null;
	}

	public Agencia getAgencia() {
		if(agencia == null)
			agencia = agenciaEjb.getAgencia(getAgenciaId());
		return agencia;
	}
	
}
