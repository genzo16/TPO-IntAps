package dtos;

public class SolicitudDTO {
	
	private String ID_Solcitud;
	private String estado_solicitud;
	public String getID_Solcitud() {
		return ID_Solcitud;
	}
	public void setID_Solcitud(String iD_Solcitud) {
		ID_Solcitud = iD_Solcitud;
	}
	public String getEstado_solicitud() {
		return estado_solicitud;
	}
	public void setEstado_solicitud(String estado_solicitud) {
		this.estado_solicitud = estado_solicitud;
	}

}
