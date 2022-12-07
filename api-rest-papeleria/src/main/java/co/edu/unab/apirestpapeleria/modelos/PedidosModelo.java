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
    private String id_pedido;
    private String nombrecliente;
    private String apellidocliente;
    private Long ndocumento;
    private Object orden;
    private LocalDate fecha_pedido;
    private LocalDate fecha_despacho;
    private Object direccion;
    private List<DespachoModel> citas;

    //private String id;
    //private String nombre;
    //private String apellido;
    //private Long ndocumento;
    //private Object orden;
    //private Object direccion;
    
}
