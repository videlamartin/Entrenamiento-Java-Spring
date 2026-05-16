package com.tallerwebi.dominio.exceptions;

public class TemperaturaNulaException extends Throwable {

  private String mensaje;

  public TemperaturaNulaException(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
}
