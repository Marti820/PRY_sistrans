package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.CiudadRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;



@RestController
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public String ciudades(Model model) {
        model.addAttribute("ciudades",ciudadRepository.getCiudades());
        return model.toString();
    }

    @GetMapping("/ciudades/new")
    public String ciudadForm(Model model){
        model.addAttribute("ciudad", new Ciudad() {
            
        });
        return "ciudadNuevo";

    }

    @PostMapping("/ciudades/new/save")
    public String ciudadGuardar(@ModelAttribute Ciudad ciudad){
      ciudadRepository.insertarCiudad(ciudad.getCiudad(),ciudad.getDepartamento());
      return "redirect:/ciudades";
    }

    @GetMapping("/ciudades/{ciudadPK}/edit")
    public String ciudadEditarForm(@PathVariable("ciudadPK") String ciudadPK, Model model){
        Ciudad ciudad = ciudadRepository.getCiudad(ciudadPK);
        if (ciudad != null){
            model.addAttribute("ciudad", ciudad);
            return "ciudadEditar";}
            else{
                return "redirect:/ciudades";
            }

    }
    @PostMapping("/ciudades/{ciudadPK}/edit/save")
    public String ciudadEditarGuardar(@PathVariable("ciudadPK") String ciudadPK, @ModelAttribute Ciudad ciudad){
        ciudadRepository.actualizarCiudad(ciudadPK,ciudad.getDepartamento());
        return "redirect:/ciudades";


    }

    @GetMapping("/ciudades/{ciudadPK}/delete")
    public String ciudadEliminar(@PathVariable("ciudadPK")String ciudadPK){
        ciudadRepository.eliminarCiudad(ciudadPK);
        return "redirect:/ciudades";

    }
    }
