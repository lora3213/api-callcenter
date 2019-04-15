package co.almundo.callcenter;

import co.almundo.callcenter.app.CallCenterApplication;
import co.almundo.callcenter.model.Estado;
import co.almundo.callcenter.model.Llamada;
import co.almundo.callcenter.service.DispatcherService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

/**
 * CallCenterApplicationTests
 *
 * <p>Clase que contiene las pruebas unitarias</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = CallCenterApplication.class)
@ActiveProfiles("test")
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class CallCenterApplicationTests {

	@Autowired
	DispatcherService dispatcherService;
	Llamada llamada1, llamada2, llamada3, llamada4, llamada5, llamada6, llamada7, llamada8, llamada9, llamada10, llamada11, llamada12;

	@Before
	public void setup() {

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

		llamada7 = new Llamada();
		llamada7.setId("007");
		llamada7.setNombrePersona("Carmen Alicia");
		llamada7.setNumeroOrigen("3134566787");
		llamada7.setEstado(Estado.EN_ESPERA.getValor());

		llamada8 = new Llamada();
		llamada8.setId("008");
		llamada8.setNombrePersona("Johana Aguirre");
		llamada8.setNumeroOrigen("3134564534");
		llamada8.setEstado(Estado.EN_ESPERA.getValor());

		llamada9 = new Llamada();
		llamada9.setId("009");
		llamada9.setNombrePersona("Mabel Lora");
		llamada9.setNumeroOrigen("3134564343");
		llamada9.setEstado(Estado.EN_ESPERA.getValor());

		llamada10 = new Llamada();
		llamada10.setId("010");
		llamada10.setNombrePersona("Rafael Lopez");
		llamada10.setNumeroOrigen("3134562333");
		llamada10.setEstado(Estado.EN_ESPERA.getValor());

		llamada11 = new Llamada();
		llamada11.setId("011");
		llamada11.setNombrePersona("Rafael Perez");
		llamada11.setNumeroOrigen("3134562234");
		llamada11.setEstado(Estado.EN_ESPERA.getValor());

		llamada12 = new Llamada();
		llamada12.setId("012");
		llamada12.setNombrePersona("Raton Gomez");
		llamada12.setNumeroOrigen("3134562233");
		llamada12.setEstado(Estado.EN_ESPERA.getValor());
	}


	@Test
	public void testADiezLlamadas() {
		try{
			CompletableFuture<Llamada> primeraLlamada = dispatcherService.dispatchCall(llamada1);
			CompletableFuture<Llamada> segundaLlamada = dispatcherService.dispatchCall(llamada2);
			CompletableFuture<Llamada> terceraLlamada = dispatcherService.dispatchCall(llamada3);
			CompletableFuture<Llamada> cuartaLlamada = dispatcherService.dispatchCall(llamada4);
			CompletableFuture<Llamada> quintaLlamada = dispatcherService.dispatchCall(llamada5);
			CompletableFuture<Llamada> sextaLlamada = dispatcherService.dispatchCall(llamada6);
			CompletableFuture<Llamada> septimaLlamada = dispatcherService.dispatchCall(llamada7);
			CompletableFuture<Llamada> octavaLlamada = dispatcherService.dispatchCall(llamada8);
			CompletableFuture<Llamada> novenaLlamada = dispatcherService.dispatchCall(llamada9);
			CompletableFuture<Llamada> decimaLlamada = dispatcherService.dispatchCall(llamada10);
			CompletableFuture.allOf(primeraLlamada,segundaLlamada,terceraLlamada,cuartaLlamada,quintaLlamada,sextaLlamada,septimaLlamada,octavaLlamada,novenaLlamada,decimaLlamada).join();
		}catch(Exception e){
			System.out.println("ERROR: " + e.getStackTrace());
		}
	}

	@Test
	public void testBDoceLlamadas() {
		try{
			CompletableFuture<Llamada> primeraLlamada = dispatcherService.dispatchCall(llamada1);
			CompletableFuture<Llamada> segundaLlamada = dispatcherService.dispatchCall(llamada2);
			CompletableFuture<Llamada> terceraLlamada = dispatcherService.dispatchCall(llamada3);
			CompletableFuture<Llamada> cuartaLlamada = dispatcherService.dispatchCall(llamada4);
			CompletableFuture<Llamada> quintaLlamada = dispatcherService.dispatchCall(llamada5);
			CompletableFuture<Llamada> sextaLlamada = dispatcherService.dispatchCall(llamada6);
			CompletableFuture<Llamada> septimaLlamada = dispatcherService.dispatchCall(llamada7);
			CompletableFuture<Llamada> octavaLlamada = dispatcherService.dispatchCall(llamada8);
			CompletableFuture<Llamada> novenaLlamada = dispatcherService.dispatchCall(llamada9);
			CompletableFuture<Llamada> decimaLlamada = dispatcherService.dispatchCall(llamada10);
			CompletableFuture<Llamada> undecimaLlamada = dispatcherService.dispatchCall(llamada11);
			CompletableFuture<Llamada> duodecimaLlamada = dispatcherService.dispatchCall(llamada12);
			CompletableFuture.allOf(primeraLlamada,segundaLlamada,terceraLlamada,cuartaLlamada,quintaLlamada,sextaLlamada,septimaLlamada,octavaLlamada,novenaLlamada,decimaLlamada, undecimaLlamada, duodecimaLlamada).join();
		}catch(Exception e){
			System.out.println("ERROR: " + e.getStackTrace());
		}
	}
}
