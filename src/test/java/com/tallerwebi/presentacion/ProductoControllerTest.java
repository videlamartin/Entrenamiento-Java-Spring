package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.tallerwebi.dominio.Producto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class ProductoControllerTest {

  private ProductoController productoController;

  @BeforeEach
  public void init() {
    productoController = new ProductoController();
  }

  // tests de la lista
  @Test
  public void queAlAccederAProductosDevuelveVistaProductos() {
    ModelAndView mav = productoController.listarProductos();
    assertThat(mav.getViewName(), equalToIgnoringCase("productos"));
  }

  @Test
  public void queAlAccederAProductosExisteElAtributoProductos() {
    ModelAndView mav = productoController.listarProductos();
    assertThat(mav.getModel().get("productos"), instanceOf(List.class));
  }

  @Test
  public void queAlAccederAProductosLaListaTieneTresProductos() {
    ModelAndView mav = productoController.listarProductos();
    List<Producto> productos = (List<Producto>) mav.getModel().get("productos");
    assertThat(productos, hasSize(3));
  }

  // tests del detalle
  @Test
  public void queAlVerDetalleDeUnProductoExistenteDevuelveVistaDetalle() {
    ModelAndView mav = productoController.verDetalle(1L);
    assertThat(mav.getViewName(), equalToIgnoringCase("detalle"));
  }

  @Test
  public void queAlVerElDetalleDeUnProductoExistenteElModeloTieneElProducto() {
    ModelAndView mav = productoController.verDetalle(1L);
    assertThat(mav.getModel().get("producto"), instanceOf(Producto.class));
  }

  @Test
  public void queAlVerDetalleDeUnProductoElNombreEsElCorrecto() {
    ModelAndView mav = productoController.verDetalle(1L);
    Producto producto = (Producto) mav.getModel().get("producto");
    assertThat(producto.getId(), equalTo(1L));
  }

  @Test
  public void queAlVerDetalleDeUnProductoInexistenteDevuelveVistaProductos() {
    ModelAndView mav = productoController.verDetalle(99L);
    assertThat(mav.getViewName(), equalToIgnoringCase("productos"));
  }
}
