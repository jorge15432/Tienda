package com.Tienda.controller;

import com.Tienda.entity.Pais;
import com.Tienda.entity.Persona;
import com.Tienda.service.IPaisService;
import com.Tienda.service.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;
@Autowired
private IPaisService paisService;

    @GetMapping("/personas")
    public String index(Model model) {

        List<Persona> listaPersonas = personaService.getAllPerson();
        model.addAttribute("titulo", "Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";

    }

@GetMapping("/personasN")
public String crearPersona(Model model){
List<Pais> listaPais=paisService.listCountry();
model.addAttribute("personas",new Persona());
model.addAttribute("paises", listaPais);
return "crear";
}

@PostMapping("/save")
public String guardarPersona(Persona persona){
personaService.savePerson(persona);
return "redirect:/personas";
}
@GetMapping ("/editPersona/{id}")
public String editarPersona(@PathVariable("id") Long idPersona, Model model){
Persona persona=personaService.getPersonaById(idPersona);
List<Pais> listaPais=paisService.listCountry();
model.addAttribute("personas",persona);
model.addAttribute("paises",listaPais);
return"crear";
}
@GetMapping("delete/{id}")
public String eliminarPersona (@PathVariable("id")Long idPersona)
{
personaService.delete(idPersona);
return "redirect:/personas";
}
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Persona persona) {
        return "crear";
    }

  

}
