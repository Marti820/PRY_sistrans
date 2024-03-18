package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;
    @Id
    private String numero_Documento;
    
    public Persona(String numero_Documento) {
       // this.id = id;
        this.numero_Documento = numero_Documento;
    }
    public Persona()
    {;}
    /* 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }*/
    public String getNumeroDocumento() {
        return numero_Documento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numero_Documento = numeroDocumento;
    }
    
    
}

