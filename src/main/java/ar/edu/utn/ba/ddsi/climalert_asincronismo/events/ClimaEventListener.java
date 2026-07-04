package ar.edu.utn.ba.ddsi.climalert_asincronismo.events;


import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.MailService;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ClimaEventListener {

  private final MailService mailService;

  public ClimaEventListener(MailService mailService) {
    this.mailService = mailService;
  }

  @RabbitListener(queues = "${climalert.alertas.queue}")
  public void onClimaRegistrado(Clima alertaClimaEvent) {
    try {
      mailService.enviarMailDeAlerta(alertaClimaEvent);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

  }
}
