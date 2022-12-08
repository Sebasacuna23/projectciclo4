package co.edu.unab.apirestpapeleria.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestpapeleria.modelos.ProductoModel;
import co.edu.unab.apirestpapeleria.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public ProductoModel saveProducto(ProductoModel producto) {
        producto.setNombre(producto.getNombre().toLowerCase());
        return productoRepositorio.save(producto);
    }

    public List<ProductoModel> getAllProductos() {
        List<ProductoModel> listaProductos = productoRepositorio.findAll();
        listaProductos.sort(Comparator.comparing(ProductoModel::getNombre));
        return listaProductos;
    }

    public String deleteProducto(String id) {
        if (productoRepositorio.existsById(id)) {
            Optional<ProductoModel> producto = productoRepositorio.findById(id);
            productoRepositorio.deleteById(id);
            return "Producto " + producto.get().getNombre() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

}
