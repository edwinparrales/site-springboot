package epv.tecnologia.site3.service;

import epv.tecnologia.site3.entity.Producto;
import epv.tecnologia.site3.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> findAll() {

        return productoRepository.findAll();
    }

    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }
}
