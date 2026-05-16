package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class ValidadorFortalezaPasswordTest {

  // --------- INVALIDA ---------

  @Test
  public void queUnaPasswordNulaDevuelveInvalida() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza(null);
    assertThat(resultado, equalTo("INVALIDA"));
  }

  @Test
  public void queUnaPasswordVaciaDevuelveInvalida() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("");
    assertThat(resultado, equalTo("INVALIDA"));
  }

  // --------- DEBIL ---------

  @Test
  public void queUnaPasswordDeUnCaracterDevuelveDebil() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("X");
    assertThat(resultado, equalTo("DEBIL"));
  }

  @Test
  public void queUnaPasswordDeOchoCaracteresDeLetrasDevuelveDebil() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("ABCDEFGH");
    assertThat(resultado, equalTo("DEBIL"));
  }

  @Test
  public void queUnaPasswordDeCuatroCaracteresDevuelveDebil() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("ABCD");
    assertThat(resultado, equalTo("DEBIL"));
  }

  // --------- MEDIANA ---------

  @Test
  public void queUnaPasswordConMasOchoCaracteresNumeroYEspecialDevuelveMediana() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("ABCDEFG$1");
    assertThat(resultado, equalTo("MEDIANA"));
  }

  @Test
  public void queUnaPasswordConDosNumerosYUnEspecialNoEsFuerteDevuelveMediana() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("12$ABCDEF");
    assertThat(resultado, equalTo("MEDIANA"));
  }

  @Test
  public void queUnaPasswordConUnNumeroYDosEspecialesNoEsFuerteDevuelveMediana() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("1$ABCDEF!");
    assertThat(resultado, equalTo("MEDIANA"));
  }

  // --------- FUERTE ---------

  @Test
  public void queUnaPasswordConCuatroLetrasDosnumerosYDosEspecialesDevuelveFuerte() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("ABCD12$!");
    assertThat(resultado, equalTo("FUERTE"));
  }

  @Test
  public void queUnaPasswordConMasDeOchoCaracteresYCriteriosFuerteDevuelveFuerte() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado = validador.validarFortaleza("!$#123ABCDEF");
    assertThat(resultado, equalTo("FUERTE"));
  }

  @Test
  public void contraseñasDeEjercicioValidadas() {
    ValidadorFortalezaPassword validador = new ValidadorFortalezaPassword();
    String resultado1 = validador.validarFortaleza("12@$abcd22%?");
    String resultado2 = validador.validarFortaleza("12abcd@$");
    String resultado3 = validador.validarFortaleza("12abcdef@$");
    String resultado4 = validador.validarFortaleza("abc@1def");
    String resultado5 = validador.validarFortaleza("abcdef@1");
    String resultado6 = validador.validarFortaleza("@1abcdef");
    String resultado7 = validador.validarFortaleza("abcdefgh");
    String resultado8 = validador.validarFortaleza("abcdef");
    String resultado9 = validador.validarFortaleza("abcd");
    String resultado0 = validador.validarFortaleza(null);
    assertThat(resultado1, equalTo("FUERTE"));
    assertThat(resultado2, equalTo("FUERTE"));
    assertThat(resultado3, equalTo("FUERTE"));
    assertThat(resultado4, equalTo("MEDIANA"));
    assertThat(resultado5, equalTo("MEDIANA"));
    assertThat(resultado6, equalTo("MEDIANA"));
    assertThat(resultado7, equalTo("DEBIL"));
    assertThat(resultado8, equalTo("DEBIL"));
    assertThat(resultado9, equalTo("DEBIL"));
    assertThat(resultado0, equalTo("INVALIDA"));
  }
}
