package co.almundo.callcenter.model;

/**
 * Llamada
 *
 * <p> POJO para representar la llamada </p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
public class Llamada {

    private String id;
    private String numeroOrigen;
    private String nombrePersona;
    private String estado;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(String numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
