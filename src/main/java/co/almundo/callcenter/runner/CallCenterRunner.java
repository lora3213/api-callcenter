package co.almundo.callcenter.runner;


import co.almundo.callcenter.model.Estado;
import co.almundo.callcenter.model.Llamada;
import co.almundo.callcenter.service.DispatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * CallCenterRunner
 *
 * <p> Clase que realiza una ejecucion de prueba al momento de iniciar el microservicio</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
@Component
    public class CallCenterRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CallCenterRunner.class);

    @Autowired
    DispatcherService dispatcherService;
    Llamada llamada1, llamada2, llamada3, llamada4, llamada5, llamada6;

    /**
     * CallCenterRunner
     *
     * <p>Constructor que inicializa los valores de prueba</p>
     *
     *
     */
    public CallCenterRunner() {

        llamada1 = new Llamada();
        llamada1.setId("001");
        llamada1.setNombrePersona("Diego Aguirre");
        llamada1.setNumeroOrigen("3014172233");
        llamada1.setEstado(Estado.EN_ESPERA.getValor());

        llamada2 = new Llamada();
        llamada2.setId("002");
        llamada2.setNombrePersona("Paola Dallos");
        llamada2.setNumeroOrigen("3017844256");
        llamada2.setEstado(Estado.EN_ESPERA.getValor());

        llamada3 = new Llamada();
        llamada3.setId("003");
        llamada3.setNombrePersona("Jairo Dallos");
        llamada3.setNumeroOrigen("3138484748");
        llamada3.setEstado(Estado.EN_ESPERA.getValor());

        llamada4 = new Llamada();
        llamada4.setId("004");
        llamada4.setNombrePersona("Patricia Ortiz");
        llamada4.setNumeroOrigen("3142601651");
        llamada4.setEstado(Estado.EN_ESPERA.getValor());

        llamada5 = new Llamada();
        llamada5.setId("005");
        llamada5.setNombrePersona("Jairo Andres Dallos");
        llamada5.setNumeroOrigen("3104801147");
        llamada5.setEstado(Estado.EN_ESPERA.getValor());

        llamada6 = new Llamada();
        llamada6.setId("006");
        llamada6.setNombrePersona("Jose Aguirre");
        llamada6.setNumeroOrigen("3133298712");
        llamada6.setEstado(Estado.EN_ESPERA.getValor());
    }


    @Override
    public void run(String... args) throws Exception {

        try{
            long start = System.currentTimeMillis();

            CompletableFuture<Llamada> primeraLlamada = dispatcherService.dispatchCall(llamada1);
            CompletableFuture<Llamada> segundaLlamada = dispatcherService.dispatchCall(llamada2);
            CompletableFuture<Llamada> terceraLlamada = dispatcherService.dispatchCall(llamada3);
            CompletableFuture<Llamada> cuartaLlamada = dispatcherService.dispatchCall(llamada4);
            CompletableFuture<Llamada> quintaLlamada = dispatcherService.dispatchCall(llamada5);
            CompletableFuture<Llamada> sextaLlamada = dispatcherService.dispatchCall(llamada6);

            CompletableFuture.allOf(primeraLlamada,segundaLlamada,terceraLlamada,cuartaLlamada,quintaLlamada,sextaLlamada).join();

            logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        }catch(Exception e){
            logger.error("Error: " + e.getStackTrace());
        }
    }
}
