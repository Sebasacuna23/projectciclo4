package co.edu.unab.apirestpapeleria.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestpapeleria.modelos.ClienteModel;

@Repository
public interface ClienteRepositorio extends MongoRepository<ClienteModel, String> {

}
