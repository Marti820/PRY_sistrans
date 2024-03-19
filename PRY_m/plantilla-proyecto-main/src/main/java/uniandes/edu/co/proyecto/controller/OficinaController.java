package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.modelo.Oficina;



@RestController
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas")
    public String oficinas(Model model) {
        model.addAttribute("nombre",oficinaRepository.getOficinas());
        return model.toString();
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model){
        model.addAttribute("oficina", new Oficina() {
            
        });
        return "oficinaNuevo";

    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina){
      oficinaRepository.insertarOficina(oficina.getNombre(),oficina.getDireccion(),oficina.getNum_puntos_atencion());
      return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{nombre}/edit")
    public String oficinaEditarForm(@PathVariable("nombre") String nombre, Model model){
        Oficina oficina = oficinaRepository.getOficinaByNombre(nombre);
        if (oficina != null){
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";}
            else{
                return "redirect:/oficinas";
            }

    }
    @PostMapping("/oficinas/{nombre}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Oficina oficina){
        oficinaRepository.actualizarOficina(nombre,oficina.getDireccion(),oficina.getNum_puntos_atencion());
        return "redirect:/oficinas";


    }

    @GetMapping("/oficinas/{nombre}/delete")
    public String oficinaEliminar(@PathVariable("nombre")String nombre){
        oficinaRepository.eliminarOficina(nombre);
        return "redirect:/oficinas";

    }
    }