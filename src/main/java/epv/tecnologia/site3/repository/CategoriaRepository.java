package epv.tecnologia.site3.repository;


import epv.tecnologia.site3.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID>, PagingAndSortingRepository<Categoria, UUID> {
}