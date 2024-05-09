package epv.tecnologia.site3.repository;
import epv.tecnologia.site3.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID>, PagingAndSortingRepository<Producto, UUID> {

}