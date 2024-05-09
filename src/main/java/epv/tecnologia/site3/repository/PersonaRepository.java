package epv.tecnologia.site3.repository;

import epv.tecnologia.site3.entity.Persona;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Integer>, PagingAndSortingRepository<Persona, Integer> {

    List<Persona> findByNombre(Pageable pageable,String nombre);

}