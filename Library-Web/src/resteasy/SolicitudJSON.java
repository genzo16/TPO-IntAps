package resteasy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SolicitudJSON 
{
	@XmlElement String id_hotel;
	@XmlElement String nombre;
	@XmlElement String direccion;
	@XmlElement String estado;
	@XmlElement String id;
	@XmlElement String fecha;
	@XmlElement String url_respuesta;
}
