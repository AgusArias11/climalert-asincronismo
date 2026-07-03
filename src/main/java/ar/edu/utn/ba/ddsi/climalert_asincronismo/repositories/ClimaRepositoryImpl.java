package ar.edu.utn.ba.ddsi.climalert_asincronismo.repositories;

import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ClimaRepositoryImpl implements ClimaRepository {
  private final List<Clima> climas = new ArrayList<>();

  @Override
  public Optional<Clima> getUltimo() {
    return climas.isEmpty() ? Optional.empty() : Optional.of(climas.getLast());
  }

  @Override
  public void save(Clima clima) {
    climas.add(clima);
  }

  @Override
  public List<Clima> getAll() {
    return new ArrayList<>(climas);
  }
}
