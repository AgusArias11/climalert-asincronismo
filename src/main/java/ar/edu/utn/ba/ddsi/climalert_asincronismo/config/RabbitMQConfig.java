package ar.edu.utn.ba.ddsi.climalert_asincronismo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

  @Bean
  public DirectExchange eventosExchange(@Value("${climalert.events.exchange}") String name) {
    return new DirectExchange(name, true, false);
  }
  @Bean
  public Queue alertasQueue(@Value("${climalert.alertas.queue}") String queue) {
    return QueueBuilder.durable(queue).build();
  }
  @Bean
  public Binding alertasBinding(Queue alertasQueue, DirectExchange eventosExchange, @Value("${climalert.alertas.routing-key}") String routingKey) {
    return BindingBuilder.bind(alertasQueue).to(eventosExchange).with(routingKey);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new JacksonJsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(messageConverter);
    return template;
  }
}