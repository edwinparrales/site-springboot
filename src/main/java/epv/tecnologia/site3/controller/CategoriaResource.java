package epv.tecnologia.site3.controller;

import epv.tecnologia.site3.entity.Categoria;
import epv.tecnologia.site3.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaResource {

    private final CategoriaService categoriaService;
    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping
    public ResponseEntity< List<Categoria>> listar() {
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }


}
