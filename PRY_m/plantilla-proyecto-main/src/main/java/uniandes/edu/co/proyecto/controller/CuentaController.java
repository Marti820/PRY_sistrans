package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.CuentasRepository;
import uniandes.edu.co.proyecto.modelo.Cuenta;

@RestController
public class CuentaController {
    @Autowired
    private CuentasRepository cuentasRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        model.addAttribute("cuentas", cuentasRepository.getCuentas());
        return model.toString();
    }

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentasRepository.insertarCuenta(cuenta.getId(), cuenta.getEstado(), cuenta.getTipo(), cuenta.getDinero());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") Integer id, Model model) {
        Cuenta cuenta = cuentasRepository.getCuenta(id);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Cuenta cuenta) {
        cuentasRepository.actualizarCuenta(id, cuenta.getEstado(), cuenta.getTipo(), cuenta.getDinero());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") Integer id) {
        cuentasRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
}