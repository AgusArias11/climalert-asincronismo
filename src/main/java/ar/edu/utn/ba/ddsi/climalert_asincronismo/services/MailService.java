package ar.edu.utn.ba.ddsi.climalert_asincronismo.services;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
      this.mailSender = mailSender;
    }

    public void enviarMailDeAlerta(Clima clima) {

      SimpleMailMessage message = new SimpleMailMessage();

      message.setTo("admin@clima.com", "emergencias@clima.com", "meteorologia@clima.com");

      message.setSubject("ALERTA CLIMÁTICA");

      message.setText(
          "Se detectó una alerta climática:\n\n" +
              "Ubicación: " + clima.getUbicacion().getNombre() + "\n" +
              "Temperatura: " + clima.getValoresClimaticos().getTemperatura() + "\n" +
              "Humedad: " + clima.getValoresClimaticos().getHumedad()
      );

      mailSender.send(message);

      System.out.println("Mail enviado correctamente");
    }
}
