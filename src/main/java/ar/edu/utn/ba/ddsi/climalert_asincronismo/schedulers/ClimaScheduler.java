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

  @Scheduled(fixedRate = 60000) // 60000 = 1 minuto
  public void obtenerClimaActual(){
    Optional<Clima> climaActual = buscadorDeClima.obtenerClimaActual();
    climaActual.ifPresent(climaRepository::save);
    /*System.out.println("====================================");
    System.out.println("ESTOY DENTRO DEL SCHEDULER");
    System.out.println("====================================");

    climaActual.ifPresent(clima -> System.out.println("Clima Actual: " + clima));

    System.out.println("------------------------------------------");
    System.out.println("Climas almacenados" + climaRepository.getAll());
    System.out.println("------------------------------------------");*/
  }
}
