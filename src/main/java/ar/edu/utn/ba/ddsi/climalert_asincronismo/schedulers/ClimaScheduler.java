package ar.edu.utn.ba.ddsi.climalert_asincronismo.schedulers;


import ar.edu.utn.ba.ddsi.climalert_asincronismo.repositories.ClimaRepository;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.BuscadorDeClima;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClimaScheduler {
  private final BuscadorDeClima buscadorDeClima;
  private final ClimaRepository climaRepository;

  @Scheduled(fixedRate = 300000) // 300000ms = 5 minutos
  public void obtenerClimaActual(){
    Optional<Clima> climaActual = buscadorDeClima.obtenerClimaActual();
    climaActual.ifPresent(climaRepository::save);

    /*System.out.println("Clima Actual: " + climaActual.get());
    System.out.println("------------------------------------------");
    System.out.println("Climas almacenados" + climaRepository.getAll());
    System.out.println("------------------------------------------");*/
  }
}
