package co.edu.unab.apirestpapeleria.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestpapeleria.Servicios.ClienteServicio;
import co.edu.unab.apirestpapeleria.modelos.ClienteModel;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteServicio clienteServicio;

    @GetMapping
    public List<ClienteModel> getAllClientes() {
        return clienteServicio.getAllClientes();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> getCliente(@PathVariable("id") String id) {
        return clienteServicio.getCliente(id);
    }

    @PostMapping
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente) {
        return clienteServicio.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable("id") String id) {
        return clienteServicio.deleteCliente(id);
    }
}
