package de.unimuenster.pi.library.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedioDePago implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;
	
    public MedioDePago(){}
	
    public MedioDePago(String nombre) 
    {
        this.nombre 	= nombre;
    }
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
