package epv.tecnologia.site3.controller;

import epv.tecnologia.site3.entity.Producto;
import epv.tecnologia.site3.service.ProductoService;
import epv.tecnologia.site3.util.FileUploadServer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("producto") @AllArgsConstructor
public class ProductoResource {
    @Autowired
    FileUploadServer fileUploadServer;
    @Autowired
    ProductoService productoService;
    private final HttpServletRequest request;


    @GetMapping("listar")
    public ResponseEntity<List<Producto>> listar() {

       return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.create(producto),HttpStatus.CREATED);
    }



    @PostMapping("loadFile")
    public ResponseEntity<String> loadFile(@RequestParam("file") MultipartFile file) {

        String nombreArchivo =  fileUploadServer.store(file);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/producto/")
                .path(nombreArchivo)
                .toUriString();
        return  ResponseEntity.ok(url);
    }

    @GetMapping("{filename:.*}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = fileUploadServer.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE,contentType)
                .body(file);

    }


}
