package co.edu.unab.apirestpapeleria.modelos;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private List<String> telefonos;
    private String direccion;
    private String email;
    private String password;

}
