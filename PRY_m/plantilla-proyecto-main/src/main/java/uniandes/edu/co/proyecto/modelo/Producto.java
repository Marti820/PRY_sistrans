package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.*;


@Entity
@Table(name = "producto")
public class Producto {
   
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "numero_Documento")
    private Cliente cliente;
    //private String estado;


    public Producto()
        {;}

    public Producto(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        }
        
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    
}

