package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class ClienteController {
       @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.getClientes());
        return model.toString();
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
        clienteRepository.insertarCliente(cliente.getNumero_Documento(), cliente.getTipo_Documento(),
                cliente.getNombre(), cliente.getNacionalidad(), cliente.getDirecciones(),
                cliente.getDireccionElectronica(), cliente.getTelefono(), cliente.getPalabraClave(),
                cliente.getTipoCliente());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{numeroDocumento}/edit")
    public String clienteEditarForm(@PathVariable("numeroDocumento") int numeroDocumento, Model model) {
        Cliente cliente = clienteRepository.getClienteByNumeroDocumento(numeroDocumento);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{numeroDocumento}/edit/save")
    public String clienteEditarGuardar(@PathVariable("numeroDocumento") int numeroDocumento,
            @ModelAttribute Cliente cliente) {
        clienteRepository.actualizarCliente(numeroDocumento, cliente.getTipo_Documento(), cliente.getNombre(),
                cliente.getNacionalidad(), cliente.getDirecciones(), cliente.getDireccionElectronica(),
                cliente.getTelefono(), cliente.getPalabraClave(), cliente.getTipoCliente());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{numeroDocumento}/delete")
    public String clienteEliminar(@PathVariable("numeroDocumento") int numeroDocumento) {
        clienteRepository.eliminarCliente(numeroDocumento);
        return "redirect:/clientes";
    }
}
