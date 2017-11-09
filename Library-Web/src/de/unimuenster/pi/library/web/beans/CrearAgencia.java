package de.unimuenster.pi.library.web.beans;


import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;

import de.unimuenster.pi.library.ejb.AgenciaService;
import de.unimuenster.pi.library.ejb.BookService;
import de.unimuenster.pi.library.jpa.Agencia;
import de.unimuenster.pi.library.jpa.Book;
import de.unimuenster.pi.library.web.Util;

/**
 * Backing bean for the create book page.
 * @author Henning Heitkoetter
 *
 */
@ManagedBean
public class CrearAgencia {
	private Agencia agencia;
	private Agencia lastAgencia;
	
	private boolean batch;
	
	private String errorMessage;
	
	@EJB
	private AgenciaService agenciaService;

	public Agencia getAgencia() {
		if(agencia == null)
			agencia = new Agencia();
		return agencia;
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
			lastAgencia = agenciaService.crearAgencia(getAgencia());
			agencia = null;
			errorMessage = null;
		}
		catch(EJBException e){
			errorMessage = "Agencia no creada: " + Util.getConstraintMessage(e);
		}
		
		//Navigation
		if(isBatch() || errorMessage != null)
			return null;
		else
			return "listaAgencias";
	}

	public String getLastResult(){
		if(lastAgencia != null){
			return "Agencia creada: " + lastAgencia.toString();
		}
		return errorMessage!=null?errorMessage:"";
	}
	
	public String getSuccess(){
		return errorMessage!=null?"error":"success";
	}
}
