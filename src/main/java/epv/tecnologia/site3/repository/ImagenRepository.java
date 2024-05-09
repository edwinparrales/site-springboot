package epv.tecnologia.site3.repository;

import epv.tecnologia.site3.entity.Imagen;
import epv.tecnologia.site3.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
public interface ImagenRepository extends JpaRepository<Imagen,Integer>,PagingAndSortingRepository<Imagen, Integer> {

   public List<Imagen> findByProducto(Producto producto);
}