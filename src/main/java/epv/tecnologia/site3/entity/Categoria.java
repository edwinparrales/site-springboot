package epv.tecnologia.site3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}