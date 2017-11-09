package dtos;

import java.io.Serializable;

import de.unimuenster.pi.library.jpa.Agencia;


public abstract class AgenciaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int 	idAgencia;
	private String 	nombre;
	private String 	direccion;
	private String 	mail;
	private String 	estado;
		
	public AgenciaDTO() {
		super();
	}
    public AgenciaDTO(	String nombre , String direccion , String mail , String estado) 
    {
    	super();
        this.nombre 	= nombre;
        this.direccion 	= direccion;
        this.mail 		= mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public abstract String getClassName();
	public abstract String toJSONstring() throws Exception;
	public abstract Agencia toEntity();
	

}
