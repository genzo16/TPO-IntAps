package dtos;

import java.io.Serializable;

import de.unimuenster.pi.library.jpa.Agencia;
import enums.EstadoAgencia;


public class AgenciaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int 	idAgencia;
	private String 	nombre;
	private String 	direccion;
	private EstadoAgencia 	estado;
		
	public AgenciaDTO() {
		super();
	}
    public AgenciaDTO(int idAgencia,	String nombre , String direccion, EstadoAgencia estado) 
    {
    	super();
    	this.idAgencia = idAgencia;
        this.nombre 	= nombre;
        this.direccion 	= direccion;
        this.estado 	= estado;
    }
    public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
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
	public String toJSONstring() throws Exception {
		return null;
	}
}
