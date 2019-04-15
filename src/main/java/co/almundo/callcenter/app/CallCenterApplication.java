package co.almundo.callcenter.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.Executor;

/**
 * CallCenterApplication
 *
 * <p> Clase principal del microservicio asincronico de call center</p>
 *
 * @author Diego Aguirre
 * @since 14/04/2019
 */
@SpringBootApplication
@ComponentScan(basePackages = {"co.almundo.callcenter"})
@EnableAsync
@EnableSwagger2
	public class CallCenterApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(CallCenterApplication.class, args);
	}

	/**
	 * <p>Bean de configuracion de los hilos</p>
	 *
	 * @return Executor
	 */
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// Variable de ambiente de archivo de configuracion
		executor.setCorePoolSize(Integer.parseInt(env.getProperty("threadConfiguration.corePoolSize")));
		executor.setMaxPoolSize(Integer.parseInt(env.getProperty("threadConfiguration.maxPoolSize")));
		executor.setQueueCapacity(Integer.parseInt(env.getProperty("threadConfiguration.queueCapacity")));
		executor.setThreadNamePrefix(env.getProperty("threadConfiguration.prefixName"));
		executor.initialize();
		return executor;
	}
}
