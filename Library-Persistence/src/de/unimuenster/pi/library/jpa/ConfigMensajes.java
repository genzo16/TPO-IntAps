package de.unimuenster.pi.library.jpa;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Configuraciones")
public class ConfigMensajes implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String tipo;
	private String nombre;
	private String url;
	private String usuario;
	private String password;
	private String destino;
	private String metodo;
	private String tipoEnvio;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return usuario;
	}
	public void setUser(String user) {
		this.usuario = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public ConfigMensajes(String tipo, String nombre, String url, String usuario, String password, String destino,
			String metodo, String tipoEnvio) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.url = url;
		this.usuario = usuario;
		this.password = password;
		this.destino = destino;
		this.metodo = metodo;
		this.tipoEnvio = tipoEnvio;
	}
	public ConfigMensajes() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getTipoEnvio() {
		return tipoEnvio;
	}
	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
	
}
