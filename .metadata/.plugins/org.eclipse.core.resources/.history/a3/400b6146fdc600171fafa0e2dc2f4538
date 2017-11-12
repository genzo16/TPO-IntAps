package de.unimuenster.pi.library.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class Paquete implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int 			id;
	private String 			nombre;
	private String 			descripcion;
	private Date   			fechaHasta;
	private Date 			fechaDesde;	     
	//@ManyToOne
	//@JoinColumn(name="idAgencia")
	private String 		agencia;
	private String 			destino;
	private String   		estado; 
	private int   			cupo;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getfechaDesde() {
		return fechaDesde;
	}
	public void setfechaDesde(Date fechaDesdee) {
		this.fechaDesde = fechaDesdee;
	}
	public Date getfechaHasta() {
		return fechaHasta;
	}
	public void setfechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Paquete(){}  
	
	
	public Paquete(String nombre, String descripcion, Date fecha_desde, Date fecha_hasta,
			String agencia,String destino, String estado, int cupo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaDesde = fecha_desde;
		this.fechaHasta = fecha_hasta;
		this.agencia = agencia;
		this.destino = destino;
		this.estado = estado;
		this.cupo = cupo;
	}
	//public abstract PaqueteDTO toDTO();

}
