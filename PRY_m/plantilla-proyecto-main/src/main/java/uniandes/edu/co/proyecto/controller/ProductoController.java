package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.Producto;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    
    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepository.getProductos());
        return "productos";
    }
    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }

    @PostMapping("/productos/new/save")
    public String productoGuardar(@ModelAttribute Producto producto) {
        productoRepository.insertProducto(producto.getCliente().getNumero_Documento());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/edit")
    public String productoEditarForm(@PathVariable("id") int id, Model model) {
        Producto producto = productoRepository.getProductoById(id);
        if (producto != null){
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else{
            return "redirect:/productos";
        }
    }
    
    @GetMapping("/productos/{id}/edit/delete")
    public String productoEliminar(@PathVariable("id") int id) {
        productoRepository.deleteProducto(id);
        return "redirect:/productos";
    }
    
    
    
    
    
}