package ar.edu.utn.ba.ddsi.climalert_asincronismo.repositories;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
  Optional<Clima> getUltimo();
  void  save(Clima clima);
  List<Clima> getAll();
}
