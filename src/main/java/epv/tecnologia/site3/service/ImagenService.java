package epv.tecnologia.site3.service;

import epv.tecnologia.site3.entity.Imagen;
import epv.tecnologia.site3.entity.Producto;
import epv.tecnologia.site3.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {
    @Autowired
    private ImagenRepository imagenRepository;


    public List<Imagen> findAll() {

        return imagenRepository.findAll();
    }

    public Imagen findById(Integer id) {
         return imagenRepository.findById(id)
                  .orElse(null);
    }
    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }
    public void delete(Imagen imagen) {
        imagenRepository.delete(imagen);
    }

    public List<Imagen> findByProducto(Producto producto) {
        return imagenRepository.findByProducto(producto);
    }

    public List<Imagen> saveAll(List<Imagen> imagens) {
        return imagenRepository.saveAll(imagens);
    }

}
