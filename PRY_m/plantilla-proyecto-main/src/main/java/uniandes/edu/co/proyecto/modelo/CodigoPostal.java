
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "codigos_postales")
public class CodigoPostal {
    
    
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //private Integer id;
    @Id
    private Integer codigo;
    @ManyToOne
    @JoinColumn(name="ciudad", referencedColumnName = "ciudad")
    private Ciudad ciudad;
    
    
    public CodigoPostal( Integer codigo, Ciudad ciudad) {
        //this.id = id;
        this.codigo = codigo;
        this.ciudad = ciudad;
    }


    public CodigoPostal()
    {;}


    //public Integer getId() {
    //    return id;
    // }


    //public void setId(Integer id) {
    //    this.id = id;
    //}


    public Integer getCodigo() {
        return codigo;
    }


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    public Ciudad getCiudad() {
        return ciudad;
    }


    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    
}
