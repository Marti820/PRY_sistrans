package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.OperacionBancariaRepository;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;



@RestController
public class OperacionBancariaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @GetMapping("/operacionBancarias")
    public String operacionBancarias(Model model) {
        model.addAttribute("id",operacionBancariaRepository.getOperacionesBancarias());
        return model.toString();
    }

    @GetMapping("/operacionBancarias/new")
    public String operacionBancariaForm(Model model){
        model.addAttribute("operacionBancaria", new OperacionBancaria() {
            
        });
        return "operacionBancariaNuevo";

    }

    @PostMapping("/operacionBancarias/new/save")
    public String operacionBancariaGuardar(@ModelAttribute OperacionBancaria operacionBancaria){
      operacionBancariaRepository.insertarOperacionBancaria(operacionBancaria.getHora(),operacionBancaria.getFecha(),operacionBancaria.getId_Origen().getId(),operacionBancaria.getPunto_de_Atencion().getId(),
      operacionBancaria.getValor(),operacionBancaria.getTipo(),operacionBancaria.getId_Destino().getId());
      return "redirect:/operacionBancarias";
    }

    @GetMapping("/operacionBancarias/{id}/edit")
    public String operacionBancariaEditarForm(@PathVariable("id") Integer id, Model model){
        OperacionBancaria operacionBancaria = operacionBancariaRepository.getOperacionBancaria(null);
        if (operacionBancaria != null){
            model.addAttribute("operacionBancaria", operacionBancaria);
            return "operacionBancariaEditar";}
            else{
                return "redirect:/operacionBancarias";
            }

    }
    @PostMapping("/operacionBancarias/{id}/edit/save")
    public String operacionBancariaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute OperacionBancaria operacionBancaria){
        operacionBancariaRepository.actualizarOperacionBancaria(id,operacionBancaria.getHora(),operacionBancaria.getFecha(),operacionBancaria.getId_Origen().getId(),operacionBancaria.getPunto_de_Atencion().getId(),
        operacionBancaria.getValor(),operacionBancaria.getTipo(),operacionBancaria.getId_Destino().getId());
        return "redirect:/operacionBancarias";


    }

    @GetMapping("/operacionBancarias/{id}/delete")
    public String operacionBancariaEliminar(@PathVariable("id")Integer id){
        operacionBancariaRepository.eliminarOperacionBancaria(id);
        return "redirect:/operacionBancarias";

    }
    }