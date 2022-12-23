package co.edu.unab.apirestpapeleria.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidosModelo {
    @Id
    private String id;
    private String id_cliente;
    private String nombrecliente;
    // private String apellidocliente;
    private LocalDate fecha_pedido;
    // private LocalDate fecha_despacho;
    private String direccion;
    private List<DespachoModel> productos;
    
}
