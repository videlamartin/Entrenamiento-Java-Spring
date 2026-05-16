package com.tallerwebi.dominio;

public class ValidadorFortalezaPassword {

  public String validarFortaleza(String contrasenaAValidar) {
    String resultado = null;

    if (contrasenaAValidar == null || contrasenaAValidar.isEmpty()) {
      return "INVALIDA";
    }

    if (contrasenaAValidar.length() <= 8) {
      resultado = "DEBIL";
    }

    if (contrasenaAValidar.length() >= 8) {
      resultado = "DEBIL";

      if (tieneNumero(contrasenaAValidar) && tieneEspecial(contrasenaAValidar)) {
        if (esFuerte(contrasenaAValidar)) {
          resultado = "FUERTE";
        } else {
          resultado = "MEDIANA";
        }
      }
    }

    return resultado;
  }

  private boolean esFuerte(String contrasenaAValidar) {
    boolean tieneMasDe2Numeros = tieneMasDe2Numeros(contrasenaAValidar);
    boolean tieneMasDe2Especiales = tieneMasDe2Especiales(contrasenaAValidar);
    return tieneMasDe2Numeros && tieneMasDe2Especiales;
  }

  private boolean tieneMasDe2Especiales(String contrasenaAValidar) {
    int contadorDeEspecial = 0;
    boolean tieneMasDe2Especiales = false;
    for (char c : contrasenaAValidar.toCharArray()) {
      if (!Character.isDigit(c) && !Character.isLetter(c)) {
        contadorDeEspecial++;
      }
    }

    if (contadorDeEspecial >= 2) {
      tieneMasDe2Especiales = true;
    }

    return tieneMasDe2Especiales;
  }

  private boolean tieneMasDe2Numeros(String contrasenaAValidar) {
    int contadorDeNumero = 0;
    boolean tieneMasDe2Numeros = false;
    for (char c : contrasenaAValidar.toCharArray()) {
      if (Character.isDigit(c)) {
        contadorDeNumero++;
      }
    }

    if (contadorDeNumero >= 2) {
      tieneMasDe2Numeros = true;
    }

    return tieneMasDe2Numeros;
  }

  private boolean tieneEspecial(String contrasenaAValidar) {
    boolean tieneEspecial = false;

    for (char c : contrasenaAValidar.toCharArray()) {
      if (!Character.isLetter(c) && !Character.isDigit(c)) {
        tieneEspecial = true;
      }
    }
    return tieneEspecial;
  }

  private boolean tieneNumero(String contrasenaAValidar) {
    boolean tieneNumero = false;

    for (char c : contrasenaAValidar.toCharArray()) {
      if (Character.isDigit(c)) {
        tieneNumero = true;
      }
    }
    return tieneNumero;
  }
}
