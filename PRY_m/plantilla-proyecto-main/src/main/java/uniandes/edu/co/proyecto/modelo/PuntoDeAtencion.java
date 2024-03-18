package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "punto_de_atencion")
public class PuntoDeAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    @ManyToOne
    @JoinColumn(name="localizacion", referencedColumnName = "id")
    private Direccion localizacion;
    @OneToOne
    @JoinColumn(name="oficina", referencedColumnName = "nombre")
    private Oficina oficina;
    public PuntoDeAtencion(Integer id, String tipo, Direccion localizacion, Oficina oficina) {
        this.id = id;
        this.tipo = tipo;
        this.localizacion = localizacion;
        this.oficina = oficina;
    }
 public PuntoDeAtencion()
 {;}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
public Direccion getLocalizacion() {
    return localizacion;
}
public void setLocalizacion(Direccion localizacion) {
    this.localizacion = localizacion;
}
public Oficina getOficina() {
    return oficina;
}
public void setOficina(Oficina oficina) {
    this.oficina = oficina;
}
  

}

