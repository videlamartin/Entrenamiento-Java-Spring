package com.tallerwebi.dominio.exceptions;

public class TemperaturaNulaException extends Exception {

  private static final long serialVersionUID = 1L;

  public TemperaturaNulaException(String mensaje) {
    super(mensaje);
  }
}
