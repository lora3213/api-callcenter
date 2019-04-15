package co.almundo.callcenter.model;

/**
 * Estado
 *
 * <p> Enum que contiene los tipos de empleado</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
public enum TipoEmpleado {

    OPERADOR("Operador"),
    SUPERVISOR("Supervisor"),
    DIRECTOR("Director");

    private final String valor;

    private TipoEmpleado(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
