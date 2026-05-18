package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoController {

  private List<Producto> obtenerProductos() {
    List<Producto> productos = new ArrayList<>();
    productos.add(new Producto(1L, "Laptop", "Laptop gamer", 1500.00));
    productos.add(new Producto(2L, "Mouse", "Mouse inalambrico", 25.00));
    productos.add(new Producto(3L, "Teclado", "Teclado mecanico", 80.00));
    return productos;
  }

  @GetMapping("/productos")
  public ModelAndView listarProductos() {
    List<Producto> productos = obtenerProductos();
    return new ModelAndView("productos", "productos", productos);
  }

  @GetMapping("/productos/{id}")
  public ModelAndView verDetalle(@PathVariable Long id) {
    Producto producto = buscarProductoPorId(id);
    if (producto == null) {
      return listarProductos();
    }
    return new ModelAndView("detalle", "producto", producto);
  }

  private Producto buscarProductoPorId(Long id) {
    for (Producto producto : obtenerProductos()) {
      if (producto.getId().equals(id)) {
        return producto;
      }
    }
    return null;
  }
}
