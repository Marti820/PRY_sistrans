package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;
    @Id
    private int numero_Documento;
    @OneToOne
    @JoinColumn(name="numero_Documento")//, referencedColumnName = "numero_Documento")
    @MapsId
    private Persona persona;
    private String tipo_documento;
    private String nombre;
    private String nacionalidad;
    @ManyToOne
    @JoinColumn(name="direccion", referencedColumnName = "id")
    private Direccion direccion;
    private String direccion_Electronica;
    private Integer telefono;
    private String palabra_Clave;
    @ManyToOne
    @JoinColumn(name="oficina", referencedColumnName = "nombre")
    private Oficina oficina;
    private Integer sueldo;
    private String tipoEmpleado;
    public Empleado(Persona persona, String tipoDocumento, String nombre, String nacionalidad,
            Direccion direccion, String direccionElectronica, Integer telefono, String palabraClave, Oficina oficina,
            Integer sueldo, String tipoEmpleado) {
        
        this.persona = persona;
        this.tipo_documento = tipoDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.direccion_Electronica = direccionElectronica;
        this.telefono = telefono;
        this.palabra_Clave = palabraClave;
        this.oficina = oficina;
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }
    public Empleado()
    {;}
    public int getNumero_documento() {
        return numero_Documento;
    }
    public void setNumero_documento(int numero_documento) {
        this.numero_Documento = numero_documento;
    }
    public String getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public String getDireccion_Electronica() {
        return direccion_Electronica;
    }
    public void setDireccion_Electronica(String direccion_Electronica) {
        this.direccion_Electronica = direccion_Electronica;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public String getPalabra_Clave() {
        return palabra_Clave;
    }
    public void setPalabra_Clave(String palabra_Clave) {
        this.palabra_Clave = palabra_Clave;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public Integer getSueldo() {
        return sueldo;
    }
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString()
    {
        return this.numero_Documento+"|"+this.persona+"|"+this.tipo_documento+"|"+this.nombre+"|"+this.nacionalidad
        +"|"+this.direccion+"|"+this.direccion_Electronica+"|"+this.telefono+"|"+this.palabra_Clave+"|"+this.oficina+"|"+this.sueldo+"|"+this.tipoEmpleado;
    }
    
}
