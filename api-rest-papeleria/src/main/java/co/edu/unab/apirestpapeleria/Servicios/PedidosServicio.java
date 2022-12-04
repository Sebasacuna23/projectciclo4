package co.edu.unab.apirestpapeleria.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestpapeleria.modelos.PedidosModelo;
import co.edu.unab.apirestpapeleria.repositorios.PedidoRepositorio;

@Service
public class PedidosServicio {
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public PedidosModelo guardarPedido(PedidosModelo pedido){
        pedido.setNombre(pedido.getNombre().toLowerCase());
        pedido.setApellido(pedido.getApellido().toLowerCase());
        return pedidoRepositorio.save(pedido);
    }
    public List<PedidosModelo> getListPedidosOrden(){
        List<PedidosModelo> listaPedidos = pedidoRepositorio.findAll();
        listaPedidos.sort(Comparator.comparing(PedidosModelo::getApellido));
        return listaPedidos;
    }
    
    public  String eliminarPedidoPorId(String id){
        if(pedidoRepositorio.existsById(id)){
            Optional<PedidosModelo> pedido =pedidoRepositorio.findById(id);
            pedidoRepositorio.deleteById(id);
            return "El pedido del señor(a) "+pedido.get().getNombre()+ " fue eliminado";
        }else{
            return "El pedido no fue eliminado";

        }

    }
    
}

