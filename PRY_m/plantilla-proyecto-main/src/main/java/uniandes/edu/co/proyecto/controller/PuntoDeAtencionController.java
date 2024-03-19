package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.PuntoDeAtencionRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class PuntoDeAtencionController {
    @Autowired
    private PuntoDeAtencionRepository puntoDeAtencionRepository;
    
    @GetMapping("/puntosDeAtencion")
    public String puntosDeAtencion(Model model) {
        model.addAttribute("puntosDeAtencion", puntoDeAtencionRepository.getPuntosDeAtencion());
        return model.toString();
    }
    @GetMapping("/puntosDeAtencion/new")
    public String puntoDeAtencionForm(Model model) {
        model.addAttribute("puntoDeAtencion", new PuntoDeAtencion());
        return "puntoDeAtencionNuevo";
    }

    @PostMapping("/puntosDeAtencion/new/save")
    public String puntoDeAtencionGuardar(@ModelAttribute PuntoDeAtencion puntoDeAtencion) {
        puntoDeAtencionRepository.insertPuntoDeAtencion(puntoDeAtencion.getTipo(), puntoDeAtencion.getLocalizacion().getId(),puntoDeAtencion.getOficina().getNombre());
        return "redirect:/puntosDeAtencion";
    }

    @GetMapping("/puntosDeAtencion/{id}/edit")
    public String puntoDeAtencionEditarForm(@PathVariable("id") int id, Model model) {
        PuntoDeAtencion puntoDeAtencion = puntoDeAtencionRepository.getPuntoDeAtencionById(id);
        if (puntoDeAtencion != null){
            model.addAttribute("puntoDeAtencion", puntoDeAtencion);
            return "puntoDeAtencionEditar";
        } else{
            return "redirect:/puntosDeAtencion";
        }
    }
    
    @GetMapping("/puntosDeAtencion/{id}/edit/delete")
    public String puntoDeAtencionEliminar(@PathVariable("id") int id) {
        puntoDeAtencionRepository.deletePuntoDeAtencion(id);
        return "redirect:/puntosDeAtencion";
    }
    
    
    
    
    
}