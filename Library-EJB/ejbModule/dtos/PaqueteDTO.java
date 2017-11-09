package dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import de.unimuenster.pi.library.jpa.Paquete;


public abstract class PaqueteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int 			id;
	private String 			nombre;
	private String 			descripcion;
	private Date   			fecha_hasta;
	private Date 			fecha_desde;	     
	private AgenciaDTO 		agencia;
	private String 		destino;
	private String   		estado; 
	private int   			cupo;
		
	public PaqueteDTO() {
		super();
	}
	
	public PaqueteDTO(String nombre, String descripcion, Date fecha_desde, Date fecha_hasta,
			AgenciaDTO agencia,String destino, String estado, int cupo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_desde = fecha_desde;
		this.fecha_hasta = fecha_hasta;
		this.agencia = agencia;
		this.destino = destino;
		this.estado = estado;
		this.cupo = cupo;
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
		public AgenciaDTO getAgencia() {
			return agencia;
		}
		public void setAgencia(AgenciaDTO agencia) {
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

	
	public abstract String getClassName();
	public abstract String toJSONstring() throws Exception;
	public abstract Paquete toEntity();
	

}