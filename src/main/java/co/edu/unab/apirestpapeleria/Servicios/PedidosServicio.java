package co.edu.unab.apirestpapeleria.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestpapeleria.modelos.AdministradorModelo;
import co.edu.unab.apirestpapeleria.modelos.PedidosModelo;
import co.edu.unab.apirestpapeleria.repositorios.AdministradorRepositorio;
import co.edu.unab.apirestpapeleria.repositorios.PedidoRepositorio;

@Service
public class PedidosServicio {   
    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    AdministradorRepositorio administradorRepositorio;

    public List<PedidosModelo> getAllPedidos(){
        return pedidoRepositorio.findAll();
    }

    public Optional <PedidosModelo> getPedidoById(String id){
        Optional <PedidosModelo> pedido= pedidoRepositorio.findById(id);
        Optional <AdministradorModelo> cliente = administradorRepositorio.findById(pedido.get().getId_cliente());
        pedido.get().setNombrecliente(cliente.get().getNombre());
        return pedido;
    }
    public PedidosModelo savePedido(PedidosModelo pedido){
        return pedidoRepositorio.save(pedido);
    }

    public String eliminarPedidoPorId(String id){
        if(pedidoRepositorio.existsById(id)){
            pedidoRepositorio.deleteById(id);
            return "pedido eliminado";
        }else{
            return "No eliminado";
        }
    }
    
}

