package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.PersonaRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Persona;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping("/personas")
    public String personas(Model model) {
        model.addAttribute("personas", personaRepository.getPersonas());
        return model.toString();
    }

    @GetMapping("/personas/new")
    public String personaForm(Model model) {
        model.addAttribute("persona", new Persona());
        return "personaNueva";
    }

    @PostMapping("/personas/new/save")
    public String personaGuardar(@ModelAttribute Persona persona) {
        personaRepository.insertarPersona(persona.getNumeroDocumento());
        return "redirect:/personas";
    }

    @GetMapping("/personas/{id}/edit")
    public String personaEditarForm(@PathVariable("id") int id, Model model) {
        Persona persona = personaRepository.getPersonaByNumeroDocumento(id);
        if (persona != null){
            model.addAttribute("persona", persona);
            return "personaEditar";
        } else{
            return "redirect:/personas";
        }
    }
    
    @GetMapping("/personas/{id}/edit/delete")
    public String personaEliminar(@PathVariable("id") int id) {
        personaRepository.eliminarPersona(id);
        return "redirect:/personas";
    }
    
    
    
    
    

}