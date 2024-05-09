package epv.tecnologia.site3.controller;

import epv.tecnologia.site3.entity.Persona;
import epv.tecnologia.site3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaResource {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {

        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Integer id, @RequestBody Persona persona) {

          Persona persona1 = personaService.update(id,persona);
          if (persona1 != null) {

              return new ResponseEntity<>(persona1, HttpStatus.OK);
          }
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {

        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);


    }
    @DeleteMapping("/{id}")

    public ResponseEntity deletePersona(@PathVariable Integer id) {
        if(personaService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


}
