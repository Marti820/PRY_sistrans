package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import uniandes.edu.co.proyecto.repositorio.CodigoPostalRepositoty;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;


    @RestController
public class CodigoPostalController {

    @Autowired
    private CodigoPostalRepositoty codigoPostalRepository;

    @GetMapping("/codigos_postales")
    public String codigosPostales(Model model) {
        model.addAttribute("codigosPostales", codigoPostalRepository.getCodigosPostales());
        return model.toString();
    }

    @GetMapping("/codigos_postales/new")
    public String codigoPostalForm(Model model) {
        model.addAttribute("codigoPostal", new CodigoPostal());
        return "codigoPostalNuevo";
    }

    @PostMapping("/codigos_postales/new/save")
    public String codigoPostalGuardar(@ModelAttribute CodigoPostal codigoPostal) {
        codigoPostalRepository.insertCodigoPostal(codigoPostal.getCodigo(), codigoPostal.getCiudad().getCiudad());
        return "redirect:/codigos_postales";
    }

    @GetMapping("/codigos_postales/{codigo}/edit")
    public String codigoPostalEditarForm(@PathVariable("codigo") int codigo, Model model) {
        CodigoPostal codigoPostal = codigoPostalRepository.getCodigoPostalByCodigo(codigo);
        if (codigoPostal != null) {
            model.addAttribute("codigoPostal", codigoPostal);
            return "codigoPostalEditar";
        } else {
            return "redirect:/codigos_postales";
        }
    }

    @PostMapping("/codigos_postales/{codigo}/edit/save")
    public String codigoPostalEditarGuardar(@PathVariable("codigo") int codigo,
            @ModelAttribute CodigoPostal codigoPostal) {
        codigoPostalRepository.updateCodigoPostalCiudad(codigo, codigoPostal.getCiudad().getCiudad());
        return "redirect:/codigos_postales";
    }

    @GetMapping("/codigos_postales/{codigo}/delete")
    public String codigoPostalEliminar(@PathVariable("codigo") int codigo) {
        codigoPostalRepository.deleteCodigoPostal(codigo);
        return "redirect:/codigos_postales";
    }
}
