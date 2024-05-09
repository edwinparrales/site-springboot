package epv.tecnologia.site3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;
import java.util.List;
@Getter @ToString
@Setter
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "cantidad_max")
    private Integer cantidadMax;

    @Column(name = "cantidad_min")
    private Integer cantidadMin;

    @Column(name = "codigo_barras", nullable = false)
    private String codigoBarras;

    @Column(name = "codigo_interno", nullable = false)
    private String codigoInterno;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria idCategoria;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;


}