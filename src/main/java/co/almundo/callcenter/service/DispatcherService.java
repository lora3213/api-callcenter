package co.almundo.callcenter.service;

import co.almundo.callcenter.model.Llamada;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

/**
 * DispatcherService
 *
 * <p> Interface para clases de tipo dispatch</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
public interface DispatcherService {

    /**
     * dispatchCall
     *
     * <p>Funcion asincronica que se encarga de ejecutar la llamada</p>
     *
     * @param llamada
     * @return CompletableFuture<Llamada>
     *
     */
    @Async
    public CompletableFuture<Llamada> dispatchCall (Llamada llamada) throws InterruptedException;
}
