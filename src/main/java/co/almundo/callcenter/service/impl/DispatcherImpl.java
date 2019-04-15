package co.almundo.callcenter.service.impl;

import co.almundo.callcenter.model.Estado;
import co.almundo.callcenter.model.Llamada;
import co.almundo.callcenter.model.TipoEmpleado;
import co.almundo.callcenter.service.DispatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * DispatcherImpl
 *
 * <p> Clase con los metodos para controlar las llamadas</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
@Service
public class DispatcherImpl implements DispatcherService {

    @Autowired
    private Environment env;
    private static final Logger logger = LoggerFactory.getLogger(DispatcherImpl.class);

    /**
     * dispatchCall
     *
     * <p>Funcion asincronica que se encarga de ejecutar la llamada</p>
     *
     * @param llamada
     * @return CompletableFuture<Llamada>
     *
     */
    @Override
    @Async
    public CompletableFuture<Llamada> dispatchCall (Llamada llamada) throws InterruptedException{

        try{

            // modificacion del nombre del hilo
            String arregloNombreHilo = Thread.currentThread().getName().split("-")[1];
            switch (arregloNombreHilo) {
                case "1":
                    Thread.currentThread().setName(env.getProperty("threadConfiguration.prefixName") + TipoEmpleado.OPERADOR.getValor());
                    break;
                case "2":
                    Thread.currentThread().setName(env.getProperty("threadConfiguration.prefixName") + TipoEmpleado.SUPERVISOR.getValor());
                    break;
                case "3":
                    Thread.currentThread().setName(env.getProperty("threadConfiguration.prefixName") + TipoEmpleado.DIRECTOR.getValor());
                    break;
            }

            // Variable de ambiente de archivo de configuracion
            int maxTime = Integer.parseInt(env.getProperty("callConfiguration.maxTime"));
            int minTime = Integer.parseInt(env.getProperty("callConfiguration.minTime"));

            llamada.setEstado(Estado.EN_PROCESO.getValor());
            logger.info("id:" + llamada.getId() + "-" + "estado:" + llamada.getEstado() + "-" + "nombre:" + llamada.getNombrePersona() + "-" + "numero:" + llamada.getNumeroOrigen());

            // Configuracion de tiempo random entre 5 y 10 egundos
            int tiempoRandom = (int) Math.random() * (maxTime-minTime) + maxTime;
            Thread.sleep(tiempoRandom);

            llamada.setEstado(Estado.FINALIZADA.getValor());
            logger.info("id:" + llamada.getId() + "-" + "estado:" + llamada.getEstado() + "-" + "nombre:" + llamada.getNombrePersona() + "-" + "numero:" + llamada.getNumeroOrigen());

            return CompletableFuture.completedFuture(llamada);
        }catch (Exception e){
            throw e;
        }
    }
}
