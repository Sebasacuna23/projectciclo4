package co.edu.unab.apirestpapeleria.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("administrador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministradorModelo {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Long ndocumento;
    private Object datospersonales; 
}
