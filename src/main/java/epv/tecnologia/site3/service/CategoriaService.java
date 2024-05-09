package epv.tecnologia.site3.service;

import epv.tecnologia.site3.entity.Categoria;
import epv.tecnologia.site3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(UUID id) {

       return categoriaRepository.findById(id).orElse(null);
    }


}
