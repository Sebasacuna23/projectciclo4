package co.edu.unab.apirestpapeleria.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DespachoModel {
    private String idProducto;
    private String nombreProducto;
    private Long precioProducto;
    
}
