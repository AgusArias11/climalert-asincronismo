package ar.edu.utn.ba.ddsi.climalert_asincronismo.schedulers;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.events.ClimaEventPublisher;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.repositories.ClimaRepository;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.BuscadorDeClima;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class AnalisisScheduler {
    private final ClimaRepository climaRepository;
    private final ClimaEventPublisher publicadorDeAlertas;

    @Scheduled(fixedRate = 300000) // 300000ms = 5 minutos
    public void analizarClima() {
      climaRepository.getUltimo().ifPresent(climaActual -> {
        Integer temperatura = climaActual.getValoresClimaticos().getTemperatura();
        Integer humedad = climaActual.getValoresClimaticos().getHumedad();

        if(temperatura >35 && humedad>60){
          publicadorDeAlertas.publicarClima(climaActual);
        }
      });
    }
}
