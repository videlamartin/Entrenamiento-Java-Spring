package com.tallerwebi.dominio;

public class ValidadorFortalezaPassword {

  private static final int MINIMO_ESPECIALES_FUERTE = 2;
  private static final int MINIMO_NUMEROS_FUERTE = 2;
  private static final int LONGITUD_MINIMA = 8;

  public String validarFortaleza(String contrasenaAValidar) {
    if (contrasenaAValidar == null || contrasenaAValidar.isEmpty()) {
      return "INVALIDA";
    }
    if (contrasenaAValidar.length() < LONGITUD_MINIMA) {
      return "DEBIL";
    }
    if (tieneNumero(contrasenaAValidar) && tieneEspecial(contrasenaAValidar)) {
      if (esFuerte(contrasenaAValidar)) {
        return "FUERTE";
      }
      return "MEDIANA";
    }
    return "DEBIL";
  }

  private boolean esFuerte(String contrasenaAValidar) {
    return tieneMasDe2Numeros(contrasenaAValidar) && tieneMasDe2Especiales(contrasenaAValidar);
  }

  private boolean tieneMasDe2Especiales(String contrasenaAValidar) {
    long contador = contrasenaAValidar
      .chars()
      .filter(c -> !Character.isDigit(c) && !Character.isLetter(c))
      .count();
    return contador >= MINIMO_ESPECIALES_FUERTE;
  }

  private boolean tieneMasDe2Numeros(String contrasenaAValidar) {
    long contador = contrasenaAValidar.chars().filter(Character::isDigit).count();
    return contador >= MINIMO_NUMEROS_FUERTE;
  }

  private boolean tieneEspecial(String contrasenaAValidar) {
    for (char c : contrasenaAValidar.toCharArray()) {
      if (!Character.isLetter(c) && !Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  private boolean tieneNumero(String contrasenaAValidar) {
    for (char c : contrasenaAValidar.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }
}
