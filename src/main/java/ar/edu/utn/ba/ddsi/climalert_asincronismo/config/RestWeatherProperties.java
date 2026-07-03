package ar.edu.utn.ba.ddsi.climalert_asincronismo.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rest-weather")
@Data
public class RestWeatherProperties {

  private String baseUrl;
  private String apiKey;
}