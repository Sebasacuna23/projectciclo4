package co.edu.unab.apirestpapeleria.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoModel {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Long precio;
    private Integer stock;
    private Object provedor;

}
