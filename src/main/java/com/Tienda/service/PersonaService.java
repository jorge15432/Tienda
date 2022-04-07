
package com.Tienda.service;

import com.Tienda.entity.Persona;
import com.Tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tienda.service.IPersonaService;


@Service
public class PersonaService implements IPersonaService{

@Autowired

private PersonaRepository personaRepository;

@Override
public List<Persona> getAllPerson(){
return (List<Persona>)personaRepository.findAll();
}
    @Override
public void savePerson (Persona persona){

personaRepository.save(persona);
}

@Override

public Persona getPersonaById(long id){

return personaRepository.findById(id).orElse(null);
}

@Override
public void delete(long id){
personaRepository.deleteById(id);
}
@Override
public Persona findByNombre(String nombre){
return personaRepository.findByNombre(nombre);
}




}

