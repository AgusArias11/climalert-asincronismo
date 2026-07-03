package ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ubicacion {

  @JsonProperty("name")
  private String nombre;

  @JsonProperty("country")
  private String pais;

  @JsonProperty("localtime")
  private String fechaYHora;
}
