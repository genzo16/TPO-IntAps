package dtos;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import de.unimuenster.pi.library.jpa.Agencia;
import enums.EstadoAgencia;


public class AgenciaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String 	idAgencia;
	private String 	nombre;
	private String 	direccion;
	private EstadoAgencia estado_solicitud;
	private String ID_Solicitud;
	private Date fecha;
	private String url;

		
	public AgenciaDTO() {
		super();
	}
    public AgenciaDTO(String iD_Agencia, String nombre, String direccion, EstadoAgencia estado, String iD_Solicitud,
			Date fecha, String url) {
    	super();
    	this.idAgencia = iD_Agencia;
        this.nombre 	= nombre;
        this.direccion 	= direccion;
        this.estado_solicitud 	= estado;
        this.setID_Solicitud(iD_Solicitud);
        this.setFecha(fecha);
        this.setUrl(url);
        		
    }
    
	public String getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(String idAgencia) {
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
		return estado_solicitud;
	}

	public void setEstado(EstadoAgencia estado) {
		this.estado_solicitud = estado;
	}
	
	
	public String getJsonString () {
		
        JsonObject personObject = Json.createObjectBuilder()
                .add("ID_Agencia", this.getIdAgencia())
                .add("Nombre", this.getNombre())
                .add("Direccion", this.getDireccion())
                .add("Estado_Solicitud", this.getEstado().toString())
                .add("ID_Solicitud", this.getID_Solicitud())
                .add("fecha", this.getFecha().toString())
                .add("url", this.getUrl())
                .build();
         
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        writer.writeObject(personObject);
        writer.close();
        return stringWriter.getBuffer().toString();
	}
	public String getID_Solicitud() {
		return ID_Solicitud;
	}
	public void setID_Solicitud(String iD_Solicitud) {
		ID_Solicitud = iD_Solicitud;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
