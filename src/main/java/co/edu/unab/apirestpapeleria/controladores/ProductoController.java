package co.edu.unab.apirestpapeleria.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestpapeleria.Servicios.ProductoServicio;
import co.edu.unab.apirestpapeleria.modelos.ProductoModel;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public List<ProductoModel> getAllProductos() {
        return productoServicio.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<ProductoModel> getProducto(@PathVariable("id") String id){
        return productoServicio.getProducto(id);
    }

    @PostMapping
    public ProductoModel saveProducto(@RequestBody ProductoModel producto) {
        return productoServicio.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable("id") String id) {
        return productoServicio.deleteProducto(id);

    }

}
