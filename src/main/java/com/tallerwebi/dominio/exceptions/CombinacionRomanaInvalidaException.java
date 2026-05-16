package com.tallerwebi.dominio.exceptions;

public class CombinacionRomanaInvalidaException extends Throwable {

  private String mensaje;

  public CombinacionRomanaInvalidaException(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
}
