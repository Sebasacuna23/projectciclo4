package co.edu.unab.apirestpapeleria.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestpapeleria.Servicios.PedidosServicio;
import co.edu.unab.apirestpapeleria.modelos.PedidosModelo;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {
    @Autowired
    PedidosServicio pedidoServicio;
    @GetMapping("/{id}")
    public Optional<PedidosModelo> gePedidoById(@PathVariable("id") String id){
        return pedidoServicio.getPedidoById(id);

    }

    @PostMapping()
    public PedidosModelo savePedido(@RequestBody PedidosModelo pedido){
        return pedidoServicio.savePedido(pedido);
    }
}
