package resteasy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespuestaJSON {
    @XmlElement String ID_Solicitud;
    @XmlElement String Estado_Solicitud;
}
