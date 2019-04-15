package co.almundo.callcenter.model;

/**
 * Estado
 *
 * <p> Enum que contiene los valores constantes de los estados de las llamadas para trace de la llamada</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
public enum Estado {

    EN_ESPERA("EN ESPERA"),
    EN_PROCESO("EN PROCESO"),
    FINALIZADA("FINALIZADA");

    private final String valor;

    private Estado(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
