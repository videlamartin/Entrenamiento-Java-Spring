package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.instanceOf;

import com.tallerwebi.dominio.Contacto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class ContactoControllerTest {

  private ContactoController contactoController;

  @BeforeEach
  public void init() {
    contactoController = new ContactoController();
  }

  @Test
  public void queAlAccederAlFormularioDevuelveVistaContacto() {
    ModelAndView modelAndView = contactoController.mostrarFormulario();
    assertThat(modelAndView.getViewName(), equalToIgnoringCase("contacto"));
  }

  @Test
  public void queAlAccederAlFormularioExisteElAtributoContacto() {
    ModelAndView modelAndView = contactoController.mostrarFormulario();
    assertThat(modelAndView.getModel().get("contacto"), instanceOf(Contacto.class));
  }

  @Test
  public void queAlEnviarElFormularioDevuelveVistaConfirmacion() {
    Contacto contacto = new Contacto("Martin", "martin@gmail.com", "Hola");
    ModelAndView modelAndView = contactoController.procesarFormulario(contacto);
    assertThat(modelAndView.getViewName(), equalToIgnoringCase("confirmacion"));
  }

  @Test
  public void queAlEnviarElFormularioElModeloTieneElContacto() {
    Contacto contacto = new Contacto("Martin", "martin@gmail.com", "Hola");
    ModelAndView modelAndView = contactoController.procesarFormulario(contacto);
    assertThat(modelAndView.getModel().get("contacto"), instanceOf(Contacto.class));
  }

  @Test
  public void queAlEnviarElFormularioElNombreEsElCorrecto() {
    Contacto contacto = new Contacto("Martin", "martin@gmail.com", "Hola");
    ModelAndView modelAndView = contactoController.procesarFormulario(contacto);
    Contacto contactoResultado = (Contacto) modelAndView.getModel().get("contacto");
    assertThat(contactoResultado.getNombre(), equalToIgnoringCase("Martin"));
  }
}
