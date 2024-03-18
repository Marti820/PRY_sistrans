package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudades")
public class Ciudad {
   
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;
    @Id
    private String ciudad;
    private String departamento;
    public Ciudad(String ciudad, String departamento) {
        this.ciudad = ciudad;
        this.departamento = departamento;
    }
    public Ciudad()
    {;}
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    @Override
    public String toString()
    {
        return this.ciudad+"|"+this.departamento;
    }
}