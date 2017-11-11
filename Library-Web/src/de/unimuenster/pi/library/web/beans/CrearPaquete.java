package de.unimuenster.pi.library.web.beans;


import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;

import de.unimuenster.pi.library.ejb.PaqueteService;
import de.unimuenster.pi.library.jpa.Paquete;
import de.unimuenster.pi.library.web.Util;

@ManagedBean
public class CrearPaquete {
	private Paquete paquete;
	private Paquete lastPaquete;
	
	private boolean batch;
	
	private String errorMessage;
	
	@EJB
	private PaqueteService paqueteService;

	public Paquete getPaquete() {
		if(paquete == null)
			paquete = new Paquete();
		return paquete;
	}

	public boolean isBatch() {
		return batch;
	}

	public void setBatch(boolean batch) {
		this.batch = batch;
	}
	
	public String persist(){
		// Action
		try{
			lastPaquete = paqueteService.crearPaquete(getPaquete());
			paquete = null;
			errorMessage = null;
		}
		catch(EJBException e){
			errorMessage = "Paquete no creado: " + Util.getConstraintMessage(e);
		}
		
		//Navigation
		if(isBatch() || errorMessage != null)
			return null;
		else
			return "listaPaquete";
	}

	public String getLastResult(){
		if(lastPaquete != null){
			return "Agencia creada: " + lastPaquete.toString();
		}
		return errorMessage!=null?errorMessage:"";
	}
	
	public String getSuccess(){
		return errorMessage!=null?"error":"success";
	}
}
