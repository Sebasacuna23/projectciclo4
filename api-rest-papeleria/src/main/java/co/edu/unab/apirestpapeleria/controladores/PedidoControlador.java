package co.edu.unab.apirestpapeleria.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestpapeleria.Servicios.PedidosServicio;
import co.edu.unab.apirestpapeleria.modelos.PedidosModelo;


@RestController
@RequestMapping("/pedido")
public class PedidoControlador {
    @Autowired
    
    PedidosServicio pedidosServicio;

    @GetMapping()
    public List<PedidosModelo> getAllPacientesOrden(){
        return pedidosServicio.getListPedidosOrden();
    }

    @PostMapping()
    public PedidosModelo savePedido(@RequestBody PedidosModelo pedido){
       return pedidosServicio.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public String deletePedidoById(@PathVariable("id") String id){
       return pedidosServicio.eliminarPedidoPorId(id);
        
    }
}
