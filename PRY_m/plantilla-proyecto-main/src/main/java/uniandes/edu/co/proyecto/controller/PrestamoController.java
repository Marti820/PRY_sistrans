package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.Prestamo;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepository.getPrestamos());
        return "prestamos";
    }
    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.insertarPrestamo(prestamo.getId(),prestamo.getEstado(), prestamo.getTipo(),prestamo.getInteres(),
        prestamo.getCuotas(), prestamo.getValor_Cuota(), prestamo.getMonto(), prestamo.getDia_Corte(), prestamo.getSaldo_Pendiente());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") int id, Model model) {
        Prestamo prestamo = prestamoRepository.getPrestamo(id);
        if (prestamo != null){
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else{
            return "redirect:/prestamos";
        }
    }
    
    @GetMapping("/prestamos/{id}/edit/delete")
    public String prestamoEliminar(@PathVariable("id") int id) {
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/prestamos";
    }
    
    
    
    
    
}