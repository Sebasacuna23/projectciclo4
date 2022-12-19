package co.edu.unab.apirestpapeleria.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestpapeleria.modelos.AdministradorModelo;
import co.edu.unab.apirestpapeleria.repositorios.AdministradorRepositorio;

@Service
public class AdministradorServicio {
    @Autowired
    AdministradorRepositorio administradorRepositorio;

    public AdministradorModelo guardarAdmin(AdministradorModelo administrar){
        administrar.setNombre(administrar.getNombre().toLowerCase());
        administrar.setApellido(administrar.getApellido().toLowerCase());
        return administradorRepositorio.save(administrar);
    }
    public List<AdministradorModelo> getListAdminOrden(){
        List<AdministradorModelo> listaAdmin = administradorRepositorio.findAll();
        listaAdmin.sort(Comparator.comparing(AdministradorModelo::getApellido));
        return listaAdmin;
    }

    public  String eliminarAdminPorId(String id){
        if(administradorRepositorio.existsById(id)){
            Optional<AdministradorModelo> admin =administradorRepositorio.findById(id);
            administradorRepositorio.deleteById(id);
            return "El registro del señor(a) "+admin.get().getNombre()+ " fue eliminado";
        }else{
            return "El registro no fue eliminado";

        }

    }




    
}
