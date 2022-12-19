package co.edu.unab.apirestpapeleria.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestpapeleria.modelos.ClienteModel;
import co.edu.unab.apirestpapeleria.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    public ClienteModel saveCliente(ClienteModel cliente) {
        cliente.setNombre(cliente.getNombre().toLowerCase());
        cliente.setApellidos(cliente.getApellidos().toLowerCase());
        cliente.setEmail(cliente.getEmail().toLowerCase());
        return clienteRepositorio.save(cliente);
    }

    public List<ClienteModel> getAllClientes() {
        List<ClienteModel> listaProductos = clienteRepositorio.findAll();
        listaProductos.sort(Comparator.comparing(ClienteModel::getNombre));
        return listaProductos;
    }

    public Optional<ClienteModel> getCliente(String id) {
        return clienteRepositorio.findById(id);
    }

    public String deleteCliente(String id) {
        if (clienteRepositorio.existsById(id)) {
            Optional<ClienteModel> cliente = clienteRepositorio.findById(id);
            clienteRepositorio.deleteById(id);
            return "Cliente " + cliente.get().getNombre() + " eliminado";
        } else {
            return "No eliminado";

        }
    }

}
