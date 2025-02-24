package spring.fit_zone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer membresia;

//    @Override
//    public String toString() {
//        return "Client{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", apellidos='" + apellidos + '\'' +
//                ", membresia=" + membresia +
//                '}';
//    }
}
