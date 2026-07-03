package ar.edu.utn.ba.ddsi.climalert_asincronismo;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.config.RestWeatherProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RestWeatherProperties.class)
public class ClimalertAsincronismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimalertAsincronismoApplication.class, args);
	}

}
