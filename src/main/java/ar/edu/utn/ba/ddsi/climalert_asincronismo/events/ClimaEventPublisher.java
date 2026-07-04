package ar.edu.utn.ba.ddsi.climalert_asincronismo.events;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClimaEventPublisher {
  private final RabbitTemplate rabbitTemplate;
  private final String exchange;
  private final String routingKey;

  public ClimaEventPublisher(
      RabbitTemplate rabbitTemplate,
      @Value("${climalert.events.exchange}") String exchange,
      @Value("${climalert.alertas.routing-key}") String routingKey
  ) {
    this.rabbitTemplate = rabbitTemplate;
    this.exchange = exchange;
    this.routingKey = routingKey;
  }

  public void publicarClima(Clima clima) {
    try {
      rabbitTemplate.convertAndSend(exchange, routingKey, clima);
      System.out.println("Se envió Clima: " + clima);
    } catch (AmqpException ex) {
     System.out.println("Error al enviar clima: " + clima);
    }
  }
}
