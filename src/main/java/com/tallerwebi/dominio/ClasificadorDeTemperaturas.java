package com.tallerwebi.dominio;

import com.tallerwebi.dominio.exceptions.TemperaturaNulaException;
import net.bytebuddy.implementation.bytecode.Throw;

public class ClasificadorDeTemperaturas {

  public String clasificarTemperatura(String temperatura, String escala)
    throws TemperaturaNulaException {
    Integer temperaturaConvertida = null;
    if (temperatura != null && esNumerico(temperatura)) {
      temperaturaConvertida = Integer.parseInt(temperatura);
    } else {
      throw new TemperaturaNulaException("la temperatura ingreasada es nula");
    }
    return clasificarTemperatura(temperaturaConvertida, escala);
  }

  private boolean esNumerico(String temperatura) {
    boolean valido = true;
    for (char c : temperatura.trim().replace(" ", "").toCharArray()) {
      if (Character.isLetter(c)) {
        valido = false;
      }
    }
    return valido;
  }

  public String clasificarTemperatura(Integer temperatura, String escala) {
    String resultado = null;

    if (temperatura != null && escala != null) {
      if (escala.equals("C")) {
        resultado = obtenerResulradoEnCelsius(temperatura);
      }
      if (escala.equals("F")) {
        temperatura = convertirFahrenheitACelsius(temperatura);
        resultado = obtenerResulradoEnCelsius(temperatura);
      }
    }

    return resultado;
  }

  private Integer convertirFahrenheitACelsius(Integer temperatura) {
    return (int) Math.round(((temperatura - 32) * 5.0) / 9.0);
  }

  private static String obtenerResulradoEnCelsius(Integer temperatura) {
    String resultado;
    if (temperatura < 1) {
      resultado = "CONGELANTE";
    } else if (temperatura <= 15) {
      resultado = "FRIA";
    } else if (temperatura <= 25) {
      resultado = "TEMPLADA";
    } else if (temperatura <= 35) {
      resultado = "CALUROSA";
    } else {
      resultado = "PELIGROSA";
    }
    return resultado;
  }
}
