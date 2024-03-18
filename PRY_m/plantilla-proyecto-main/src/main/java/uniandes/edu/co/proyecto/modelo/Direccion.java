package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")


public class Direccion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String direccion;
    @ManyToOne
    @JoinColumn(name="codigo_postal", referencedColumnName = "codigo")
    private CodigoPostal codigo_postal;

    

    public Direccion(Integer id, String direccion, CodigoPostal codigoPostal) {
        this.id = id;
        this.direccion = direccion;
        this.codigo_postal = codigoPostal;
    }



    public Direccion()
    {;}



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public CodigoPostal getCodigoPostal() {
        return codigo_postal;
    }



    public void setCodigoPostal(CodigoPostal codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    

    
    
}
 
