package ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoresClimaticos {
  @JsonProperty("temp_c")
  private Integer temperatura;

  @JsonProperty("humidity")
  private Integer humedad;
}
