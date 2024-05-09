package epv.tecnologia.site3.service;

import epv.tecnologia.site3.entity.Persona;
import epv.tecnologia.site3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public Persona save(Persona persona) {

        return personaRepository.save(persona);

    }

    public List<Persona> findAll() {

        return personaRepository.findAll();
    }

    public Persona update(Integer id, Persona persona) {
       Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona1 = personaOptional.get();
            persona1.setNombre(persona.getNombre());
            persona1.setApellido(persona.getApellido());
            persona1.setCorreo(persona.getCorreo());
            persona1.setNumDocumento(persona.getNumDocumento());
            persona1.setDireccion(persona.getDireccion());
            persona1.setBarrio(persona.getBarrio());
            persona1.setCiudad(persona.getCiudad());
            persona1.setTelefono(persona.getTelefono());


            return personaRepository.save(persona1);

        }else{
            return null;
        }



    }

    public Boolean delete(Integer id) {

        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        }else{

            return false;
        }


    }

    public List<Persona> saveAll(List<Persona> personas) {

        return  personaRepository.saveAll(personas);

    }

}
