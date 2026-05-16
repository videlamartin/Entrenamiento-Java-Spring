package com.tallerwebi.dominio;

import com.tallerwebi.dominio.exceptions.TemperaturaNulaException;

public class ClasificadorDeTemperaturas {

  private static final int LIMITE_CONGELANTE = 1;
  private static final int LIMITE_FRIA = 15;
  private static final int LIMITE_TEMPLADA = 25;
  private static final int LIMITE_CALUROSA = 35;

  public String clasificarTemperatura(String temperatura, String escala)
    throws TemperaturaNulaException {
    if (temperatura == null || !esNumerico(temperatura)) {
      throw new TemperaturaNulaException("la temperatura ingresada es nula");
    }
    return clasificarTemperatura(Integer.parseInt(temperatura), escala);
  }

  private boolean esNumerico(String temperatura) {
    for (char c : temperatura.trim().replace(" ", "").toCharArray()) {
      if (Character.isLetter(c)) {
        return false;
      }
    }
    return true;
  }

  public String clasificarTemperatura(Integer temperatura, String escala) {
    if (temperatura == null || escala == null) {
      return null;
    }
    if ("C".equals(escala)) {
      return obtenerResultadoEnCelsius(temperatura);
    }
    if ("F".equals(escala)) {
      return obtenerResultadoEnCelsius(convertirFahrenheitACelsius(temperatura));
    }
    return null;
  }

  private Integer convertirFahrenheitACelsius(Integer temperatura) {
    return (int) Math.round(((temperatura - 32) * 5.0) / 9.0);
  }

  private static String obtenerResultadoEnCelsius(Integer temperatura) {
    if (temperatura < LIMITE_CONGELANTE) {
      return "CONGELANTE";
    } else if (temperatura <= LIMITE_FRIA) {
      return "FRIA";
    } else if (temperatura <= LIMITE_TEMPLADA) {
      return "TEMPLADA";
    } else if (temperatura <= LIMITE_CALUROSA) {
      return "CALUROSA";
    } else {
      return "PELIGROSA";
    }
  }
}
