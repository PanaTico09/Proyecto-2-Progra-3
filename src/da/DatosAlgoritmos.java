package da;

import java.sql.Date;

/**
 *
 * @author Johan Herrera
 */
public class DatosAlgoritmos {

    private final Integer id_Algoritmo;
    private String NombreAlgoritmo;
    private String TipoEstructura;
    private Date Fecha;
    private Long Duracion;

    public DatosAlgoritmos() {
        this.id_Algoritmo = null;
        this.NombreAlgoritmo = null;
        this.TipoEstructura = null;
        this.Fecha = null;
        this.Duracion = null;
    }

    public DatosAlgoritmos(Integer id_Algoritmo, String NombreAlgoritmo, String TipoEstructura, Date Fecha, Long Duracion) {
        this.id_Algoritmo = id_Algoritmo;
        this.NombreAlgoritmo = NombreAlgoritmo;
        this.TipoEstructura = TipoEstructura;
        this.Fecha = Fecha;
        this.Duracion = Duracion;
    }

    public Integer getId_algoritmo(){
        return id_Algoritmo;
    }
    
    public String getNombreAlgoritmo() {
        return NombreAlgoritmo;
    }

    public void setNombreAlgoritmo(String NombreAlgoritmo) {
        this.NombreAlgoritmo = NombreAlgoritmo;
    }

    public String getTipoEstructura() {
        return TipoEstructura;
    }

    public void setTipoEstructura(String TipoEstructura) {
        this.TipoEstructura = TipoEstructura;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Long getDuracion() {
        return Duracion;
    }

    public void setDuracion(Long Duracion) {
        this.Duracion = Duracion;
    }

    @Override
    public String toString() {
        return "DatosAlgoritmos{" + "id_Algoritmo=" + id_Algoritmo + ", NombreAlgoritmo=" + NombreAlgoritmo
                + ", TipoEstructura=" + TipoEstructura + ", Fecha=" + Fecha + ", Duracion=" + Duracion + '}';
    }

}
