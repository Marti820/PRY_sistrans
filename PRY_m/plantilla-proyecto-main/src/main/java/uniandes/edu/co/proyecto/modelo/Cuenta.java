
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Producto produto;
    //private Integer id;
    private String estado;
    private String tipo;
    private Integer dinero;
    
    
    


    public Cuenta(Producto produto, String estado, String tipo, Integer dinero) {
        this.produto = produto;
        //this.id = id;
        this.estado = estado;
        this.tipo = tipo;
        this.dinero = dinero;
    }

    public Cuenta()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProduto() {
        return produto;
    }

    public void setProduto(Producto produto) {
        this.produto = produto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }
    
    public String toString() {
        return this.id + "|" +
                this.estado + "|" +
                this.tipo + "|" +   
                this.dinero;
    }

    
}