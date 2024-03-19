package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.Empleado;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @GetMapping("/empleados")
    public String empleados(Model model) {
        model.addAttribute("empleados", empleadoRepository.getEmpleados());
        return model.toString();
    }
    @GetMapping("/empleados/new")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleadoNuevo";
    }

    @PostMapping("/empleados/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado) {
        empleadoRepository.insertarEmpleado(empleado.getNumero_documento(),empleado.getTipo_documento(),empleado.getNombre(),empleado.getNacionalidad(),empleado.getDireccion().getId(),
      empleado.getDireccion_Electronica(),empleado.getTelefono(),empleado.getPalabra_Clave(),empleado.getOficina().getNombre(),empleado.getSueldo(),empleado.getTipoEmpleado()
      );
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{numeroDocumento}/edit")
    public String empleadoEditarForm(@PathVariable("numeroDocumento") int numeroDocumento, Model model) {
        Empleado empleado = empleadoRepository.getEmpleadoByNumeroDocumento(numeroDocumento);
        if (empleado != null){
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else{
            return "redirect:/empleados";
        }
    }
    
    @GetMapping("/empleados/{numeroDocumento}/edit/delete")
    public String empleadoEliminar(@PathVariable("numeroDocumento") int numeroDocumento) {
        empleadoRepository.eliminarEmpleado(numeroDocumento);
        return "redirect:/empleados";
    }
    
    
    
    
    
}