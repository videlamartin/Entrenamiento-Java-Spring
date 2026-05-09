package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Contacto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorContacto {

  @GetMapping("/contacto")
  public String mostrarFormulario(ModelMap modelo) {
    modelo.addAttribute("contacto", new Contacto());
    return "contacto";
  }

  @PostMapping("/contacto")
  public String procesarFormulario(@ModelAttribute Contacto contacto, ModelMap modelo) {
    modelo.addAttribute("contacto", contacto);
    return "confirmacion";
  }
}
