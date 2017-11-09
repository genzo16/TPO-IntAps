package de.unimuenster.pi.library.jpa;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destino implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private String nombre;
	private String lat;
	private String lon;
	
    public Destino(){}
	
    public Destino(	String nombre , String lat , String lon) 
    {
        this.nombre = nombre;
        this.lat 	= lat;
        this.lon 	= lon;
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
	public String getlat() {
		return lat;
	}
	public void setlat(String lat) {
		this.lat = lat;
	}
	public String getlon() {
		return lon;
	}
	public void setlon(String lon) {
		this.lon = lon;
	}
}
