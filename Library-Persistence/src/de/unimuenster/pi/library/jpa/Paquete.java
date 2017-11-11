package de.unimuenster.pi.library.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private String  		foto;  
	private int  			cant_personas;
	private float   		precio_persona;
	private String 			descripcion;
	private Date   			fecha_hasta;
	private Date 			fecha_desde;	     
	private String  		politica_cancelacion;
	//@ManyToOne
	//@JoinColumn(name="idAgencia")
	private String 		agencia;
	//@ManyToOne
	//@JoinColumn(name="idDestino")
	private String 		destino;
	private String   		estado; 
	private int   			cupo;
	//@ManyToMany(cascade=CascadeType.ALL)
	//@JoinTable(name="paquete_servicio", joinColumns=@JoinColumn(name="idServicio"),inverseJoinColumns=@JoinColumn(name="id"))
	private String 	servicios;
	//@ManyToMany(cascade=CascadeType.ALL)
	//@JoinTable(name="paquete_medioPago",joinColumns=@JoinColumn(name="idMedioPAgo"),inverseJoinColumns=@JoinColumn(name="id"))
	private String medios; 	
	
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
	public Date getfecha_desde() {
		return fecha_desde;
	}
	public void setfecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public Date getfecha_hasta() {
		return fecha_hasta;
	}
	public void setfecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	public int getcant_personas() {
		return cant_personas;
	}
	public void setcant_personas(int cant_personas) {
		this.cant_personas = cant_personas;
	}
	public float getprecio_persona() {
		return precio_persona;
	}
	public void setprecio_persona(float precio_persona) {
		this.precio_persona = precio_persona;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getpolitica_cancelacion() {
		return politica_cancelacion;
	}
	public void setpolitica_cancelacion(String politica_cancelacion) {
		this.politica_cancelacion = politica_cancelacion;
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
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public String getMedios() {
		return medios;
	}
	public void setMedios(String medios) {
		this.medios = medios;
	}

	public Paquete(){}  
	
	
	public Paquete(String nombre, String descripcion, Date fecha_desde, Date fecha_hasta,
			int cant_personas, float precio_persona, String foto, String politica_cancelacion, String agencia,
			String destino, String estado, int cupo, String servicios, String medios) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_desde = fecha_desde;
		this.fecha_hasta = fecha_hasta;
		this.cant_personas = cant_personas;
		this.precio_persona = precio_persona;
		this.foto = foto;
		this.politica_cancelacion = politica_cancelacion;
		this.agencia = agencia;
		this.destino = destino;
		this.estado = estado;
		this.cupo = cupo;
		this.servicios = servicios;
		this.medios = medios;
	}

}
