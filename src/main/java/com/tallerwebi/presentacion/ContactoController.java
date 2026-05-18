package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Contacto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactoController {

  private static final String VISTA_CONTACTO = "contacto";

  @GetMapping("/contacto")
  public ModelAndView mostrarFormulario() {
    ModelAndView mav = new ModelAndView(VISTA_CONTACTO);
    mav.addObject(VISTA_CONTACTO, new Contacto());
    return mav;
  }

  @PostMapping("/contacto")
  public ModelAndView procesarFormulario(@ModelAttribute Contacto contacto) {
    ModelAndView mav = new ModelAndView("confirmacion");
    mav.addObject(VISTA_CONTACTO, contacto);
    return mav;
  }
}
