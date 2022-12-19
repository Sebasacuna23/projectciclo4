package co.edu.unab.apirestpapeleria.controladores;

import java.util.List;

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

import co.edu.unab.apirestpapeleria.Servicios.AdministradorServicio;
import co.edu.unab.apirestpapeleria.modelos.AdministradorModelo;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class AdministradorControlador {
    @Autowired
    
    AdministradorServicio administradorServicio;

    @GetMapping()
    public List<AdministradorModelo> getAllAdminOrden(){
        return administradorServicio.getListAdminOrden();
    }

    @PostMapping()
    public AdministradorModelo savePedido(@RequestBody AdministradorModelo admin){
       return administradorServicio.guardarAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdminById(@PathVariable("id") String id){
       return administradorServicio.eliminarAdminPorId(id);
        
    }
    
}
