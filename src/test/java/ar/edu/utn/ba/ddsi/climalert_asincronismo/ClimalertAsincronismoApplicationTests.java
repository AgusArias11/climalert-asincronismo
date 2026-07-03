package ar.edu.utn.ba.ddsi.climalert_asincronismo;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.BuscadorDeClima;
import ar.edu.utn.ba.ddsi.climalert_asincronismo.services.dto.Clima;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClimalertAsincronismoApplicationTests {
	@Autowired
	private BuscadorDeClima buscadorDeClima;


	@Test
	void contextLoads() {
	}

	@Test
	void obtenerClimaActualMeDevueveAlgo() {
		Optional<Clima> clima = buscadorDeClima.obtenerClimaActual();

		System.out.println(clima);
		assertThat(clima).isNotEmpty();

	}

}
