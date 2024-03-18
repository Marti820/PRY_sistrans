package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "oficina")
public class Oficina {
    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //private Integer id;
    @Id
    private String nombre;
    @OneToOne
    @JoinColumn(name="direccion", referencedColumnName = "id")
    private Direccion direccion;
    private Integer num_puntos_atencion;
    

    public Oficina(String nombre, Direccion direccion, Integer num_puntos_atencion) {
        //this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.num_puntos_atencion = num_puntos_atencion;
    }

    public Oficina()
    {;}
    /* 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getNum_puntos_atencion() {
        return num_puntos_atencion;
    }

    public void setNum_puntos_atencion(Integer num_puntos_atencion) {
        this.num_puntos_atencion = num_puntos_atencion;
    }


    

    
}
