package de.unimuenster.pi.library.jpa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dtos.AgenciaDTO;
import enums.EstadoAgencia;

@Entity
public class Agencia implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Id
	private int id;
	private String nombre;
	private String direccion;
	@Enumerated(EnumType.ORDINAL)
	private EstadoAgencia estado;
	private String mail;

	public Agencia() {
	}

	public Agencia(String nombre, String direccion) {
		super();
		this.estado = EstadoAgencia.PENDIENTE_DE_ACTIVACION;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	

	public Agencia(int id, String nombre, String direccion, EstadoAgencia estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
	}

	public AgenciaDTO toDTO() {
		return new AgenciaDTO(id, nombre, direccion, estado);
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", estado=" + estado + "]";
	}
	
	public int getIdAgencia() {
		return id;
	}

	public void setIdAgencia(int idAgencia) {
		this.id = idAgencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public EstadoAgencia getEstado() {
		return estado;
	}

	public void setEstado(EstadoAgencia estado) {
		this.estado = estado;
	}

	public String getMail() {
		// TODO Auto-generated method stub
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}


}
