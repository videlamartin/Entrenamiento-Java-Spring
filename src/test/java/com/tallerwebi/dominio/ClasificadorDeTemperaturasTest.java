package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tallerwebi.dominio.exceptions.TemperaturaNulaException;
import org.junit.jupiter.api.Test;

public class ClasificadorDeTemperaturasTest {

  @Test
  public void queUnaTemperaturaNegativaDevuelveCongelante() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(-10, "C");

    assertThat(resultado, equalTo("CONGELANTE"));
  }

  @Test
  public void queUnaTemperaturaDeGradoCeroDevuelveCongelante() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(0, "C");

    assertThat(resultado, equalTo("CONGELANTE"));
  }

  @Test
  public void queUnaTemperaturaDe1DevuelveFria() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(1, "C");

    assertThat(resultado, equalTo("FRIA"));
  }

  @Test
  public void queUnaTemperaturaDeQuinceDevuelveFria() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(15, "C");

    assertThat(resultado, equalTo("FRIA"));
  }

  @Test
  public void queUnaTemperaturaDeDieciseisDevuelveTemplada() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(16, "C");

    assertThat(resultado, equalTo("TEMPLADA"));
  }

  @Test
  public void queUnaTemperaturaDeVeinticincoDevuelveTemplada() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(25, "C");

    assertThat(resultado, equalTo("TEMPLADA"));
  }

  @Test
  public void queUnaTemperaturaDeVeintiseisDevuelveCalurosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(26, "C");

    assertThat(resultado, equalTo("CALUROSA"));
  }

  @Test
  public void queUnaTemperaturaDeTreintaYCincoDevuelveCalurosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(35, "C");

    assertThat(resultado, equalTo("CALUROSA"));
  }

  @Test
  public void queUnaTemperaturaDeTreintaYSeisDevuelvePeligrosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(36, "C");

    assertThat(resultado, equalTo("PELIGROSA"));
  }

  @Test
  public void queUnaTemperaturaDeCuarentaDevuelvePeligrosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(40, "C");

    assertThat(resultado, equalTo("PELIGROSA"));
  }

  @Test
  public void queUnaTemperaturaDeTrientaYDosFahrenheitEsElLimiteCongelante() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(32, "F");

    assertThat(resultado, equalTo("CONGELANTE"));
  }

  @Test
  public void queUnaTemperaturaDeTrientaYTresFahrenheitEsElLimiteFria() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(33, "F");

    assertThat(resultado, equalTo("FRIA"));
  }

  @Test
  public void queUnaTemperaturaDeCincuentaYNueveFahrenheitEsElLimiteFria() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(59, "F");

    assertThat(resultado, equalTo("FRIA"));
  }

  @Test
  public void queUnaTemperaturaDeSentaFahrenheitEsElLimiteTemplada() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(60, "F");

    assertThat(resultado, equalTo("TEMPLADA"));
  }

  @Test
  public void queUnaTemperaturaDeSetentaYSieteFahrenheitEsElLimiteTemplada() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(77, "F");

    assertThat(resultado, equalTo("TEMPLADA"));
  }

  @Test
  public void queUnaTemperaturaDeSetentaYOchoFahrenheitEsElLimiteCalurosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(78, "F");

    assertThat(resultado, equalTo("CALUROSA"));
  }

  @Test
  public void queUnaTemperaturaDeNoventaYCincoFahrenheitEsElLimiteCalurosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(95, "F");

    assertThat(resultado, equalTo("CALUROSA"));
  }

  @Test
  public void queUnaTemperaturaDeNoventaYSeisFahrenheitEsElLimitePeligrosa() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura(96, "F");

    assertThat(resultado, equalTo("PELIGROSA"));
  }

  @Test
  public void queUnaTemperaturaComoStringEnCelsiusDevuelveCongelante()
    throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura("-4", "C");

    assertThat(resultado, equalTo("CONGELANTE"));
  }

  @Test
  public void queUnaTemperaturaComoStringEnCelsiusDevuelveFria() throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura("10", "C");

    assertThat(resultado, equalTo("FRIA"));
  }

  @Test
  public void queUnaTemperaturaComoStringEnCelsiusDevuelveTemplada()
    throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura("20", "C");

    assertThat(resultado, equalTo("TEMPLADA"));
  }

  @Test
  public void queUnaTemperaturaComoStringEnFahrenheitDevuelveCongelante()
    throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura("32", "F");

    assertThat(resultado, equalTo("CONGELANTE"));
  }

  @Test
  public void queUnaTemperaturaComoStringEnFahrenheitDevuelvePeligrosa()
    throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado = clasificador.clasificarTemperatura("100", "F");

    assertThat(resultado, equalTo("PELIGROSA"));
  }

  @Test
  public void queUnaTemperaturaComoStringNoNumericaLanzaExcepcion()
    throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();

    assertThrows(
      TemperaturaNulaException.class,
      () -> {
        clasificador.clasificarTemperatura("ABC", "C");
      }
    );
  }

  @Test
  public void queUnaTemperaturaComoStringNulaLanzaExcepcion() throws TemperaturaNulaException {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();

    assertThrows(
      TemperaturaNulaException.class,
      () -> {
        clasificador.clasificarTemperatura((String) null, "F");
      }
    );
  }

  @Test
  public void temperaturasDeEjercicioClasificadas() {
    ClasificadorDeTemperaturas clasificador = new ClasificadorDeTemperaturas();
    String resultado1 = clasificador.clasificarTemperatura(-3, "C");
    String resultado2 = clasificador.clasificarTemperatura(10, "C");
    String resultado3 = clasificador.clasificarTemperatura(23, "C");
    String resultado4 = clasificador.clasificarTemperatura(30, "C");
    String resultado5 = clasificador.clasificarTemperatura(42, "C");

    assertThat(resultado1, equalTo("CONGELANTE"));
    assertThat(resultado2, equalTo("FRIA"));
    assertThat(resultado3, equalTo("TEMPLADA"));
    assertThat(resultado4, equalTo("CALUROSA"));
    assertThat(resultado5, equalTo("PELIGROSA"));
  }
}
