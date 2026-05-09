package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.tallerwebi.dominio.Contacto;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class ControladorContactoTest {

  @Test
  public void queMuestreElFormularioDeContacto() {
    ControladorContacto controlador = new ControladorContacto();
    ModelMap modelo = new ModelMap();
    String vista = controlador.mostrarFormulario(modelo);
    assertThat(vista, equalTo("contacto"));
  }

  @Test
  public void queProceseLosDataosYRedirijaAConfirmacion() {
    ControladorContacto controlador = new ControladorContacto();
    Contacto contacto = new Contacto();
    contacto.setNombre("Martin");
    contacto.setEmail("martin@gmail.com");
    contacto.setMensaje("Hola!");
    ModelMap modelo = new ModelMap();
    String vista = controlador.procesarFormulario(contacto, modelo);
    assertThat(vista, equalTo("confirmacion"));
  }
}
