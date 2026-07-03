package ar.edu.utn.ba.ddsi.climalert_asincronismo.services;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.config.RestWeatherProperties;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.net.URI;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class BuscadorDeClima {

  private RestWeatherProperties properties;
  private RestTemplate restTemplate;

  public BuscadorDeClima(RestTemplate restTemplate, RestWeatherProperties properties) {
    this.restTemplate = restTemplate;
    this.properties = properties;
  }

  public Optional<Clima> obtenerClimaActual(){
    URI uri = UriComponentsBuilder
        .fromUriString(properties.getBaseUrl())
        .path("/current.json")
        .queryParam("key",properties.getApiKey())
        .queryParam("q","Buenos Aires")
        .build()
        .toUri();

    Clima clima = restTemplate.getForObject(uri, Clima.class);

    if(clima == null){
      return Optional.empty();
    }
    return Optional.of(clima);
  }
}
