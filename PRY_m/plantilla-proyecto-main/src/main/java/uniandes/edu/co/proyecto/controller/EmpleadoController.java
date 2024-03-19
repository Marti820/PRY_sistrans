package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.modelo.Empleado;



@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleadoes")
    public String empleadoes(Model model) {
        model.addAttribute("numero_Documento",empleadoRepository.getEmpleados());
        return model.toString();
    }

    @GetMapping("/empleadoes/new")
    public String empleadoForm(Model model){
        model.addAttribute("empleado", new Empleado() {
            
        });
        return "empleadoNuevo";

    }

    @PostMapping("/empleadoes/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado){
      empleadoRepository.insertarEmpleado(empleado.getNumero_documento(),empleado.getTipo_documento(),empleado.getNombre(),empleado.getNacionalidad(),empleado.getDireccion().getId(),
      empleado.getDireccion_Electronica(),empleado.getTelefono(),empleado.getPalabra_Clave(),empleado.getOficina().getNombre(),empleado.getSueldo(),empleado.getTipoEmpleado()
      );
      return "redirect:/empleadoes";
    }

    @GetMapping("/empleadoes/{numero_Documento}/edit")
    public String empleadoEditarForm(@PathVariable("numero_Documento") Integer numero_Documento, Model model){
        Empleado empleado = empleadoRepository.getEmpleadoByNumeroDocumento(numero_Documento);
        if (empleado != null){
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";}
            else{
                return "redirect:/empleadoes";
            }

    }
    @PostMapping("/empleadoes/{numero_Documento}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("numero_Documento") Integer numero_Documento, @ModelAttribute Empleado empleado){
        empleadoRepository.actualizarEmpleado(numero_Documento,empleado.getTipo_documento(),empleado.getNombre(),empleado.getNacionalidad(),empleado.getDireccion().getId(),empleado.getDireccion_Electronica(),empleado.getTelefono(),empleado.getPalabra_Clave(),empleado.getOficina().getNombre(),empleado.getSueldo(),empleado.getTipoEmpleado()
        );
        return "redirect:/empleadoes";


    }

    @GetMapping("/empleadoes/{numero_Documento}/delete")
    public String empleadoEliminar(@PathVariable("numero_Documento")Integer numero_Documento){
        empleadoRepository.eliminarEmpleado(numero_Documento);
        return "redirect:/empleadoes";

    }
    }
