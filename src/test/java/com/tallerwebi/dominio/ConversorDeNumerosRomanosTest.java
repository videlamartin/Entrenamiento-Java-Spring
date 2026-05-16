package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tallerwebi.dominio.exceptions.CombinacionRomanaInvalidaException;
import org.junit.jupiter.api.Test;

public class ConversorDeNumerosRomanosTest {

  @Test
  public void queElRomanoIDevuelveUno() throws CombinacionRomanaInvalidaException {
    String romano = "I";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(1));
  }

  @Test
  public void queElRomanoVDevuelveCinco() throws CombinacionRomanaInvalidaException {
    String romano = "V";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(5));
  }

  @Test
  public void queElRomanoXDevuelveDiez() throws CombinacionRomanaInvalidaException {
    String romano = "X";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(10));
  }

  @Test
  public void queElRomanoLDevuelveCincuenta() throws CombinacionRomanaInvalidaException {
    String romano = "L";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(50));
  }

  @Test
  public void queElRomanoCDevuelveCien() throws CombinacionRomanaInvalidaException {
    String romano = "C";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(100));
  }

  @Test
  public void queElRomanoXXDevuelveVeinte() throws CombinacionRomanaInvalidaException {
    String romano = "XX";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(20));
  }

  @Test
  public void queElRomanoXVIIDevuelveDiezYSiete() throws CombinacionRomanaInvalidaException {
    String romano = "XVII";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(17));
  }

  @Test
  public void queElRomanoIXDevuelveNueve() throws CombinacionRomanaInvalidaException {
    String romano = "IX";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(9));
  }

  @Test
  public void queElRomanoXCIXDevuelveTreintaYNueve() throws CombinacionRomanaInvalidaException {
    String romano = "XCIX";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();
    Integer resultado = conversor.convertirRomano(romano);
    assertThat(resultado, equalTo(99));
  }

  @Test
  public void queElRomanoIIIILanzaExcepcion() {
    String romano = "IIII";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();

    assertThrows(
      CombinacionRomanaInvalidaException.class,
      () -> {
        Integer resultado = conversor.convertirRomano(romano);
      }
    );
  }

  @Test
  public void queElRomanoXXXXVILanzaExcepcion() {
    String romano = "XXXXVI";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();

    assertThrows(
      CombinacionRomanaInvalidaException.class,
      () -> {
        Integer resultado = conversor.convertirRomano(romano);
      }
    );
  }

  @Test
  public void queUnStringVacioLanzaExcepcion() {
    String romano = "";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();

    assertThrows(
      CombinacionRomanaInvalidaException.class,
      () -> {
        Integer resultado = conversor.convertirRomano(romano);
      }
    );
  }

  @Test
  public void queUnStringNuloLanzaExcepcion() {
    String romano = null;
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();

    assertThrows(
      CombinacionRomanaInvalidaException.class,
      () -> {
        Integer resultado = conversor.convertirRomano(romano);
      }
    );
  }

  @Test
  public void queUnSimboloInvalidoLanzaExcepcion() {
    String romano = "ABC";
    ConversorDeNumerosRomanos conversor = new ConversorDeNumerosRomanos();

    assertThrows(
      CombinacionRomanaInvalidaException.class,
      () -> {
        Integer resultado = conversor.convertirRomano(romano);
      }
    );
  }
}
