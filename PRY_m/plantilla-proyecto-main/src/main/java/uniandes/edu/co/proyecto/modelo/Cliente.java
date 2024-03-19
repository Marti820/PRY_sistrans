package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "cliente")

public class Cliente {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;
    @Id
    private int numero_Documento;
    @OneToOne
    @JoinColumn(name="numero_Documento")//, referencedColumnName = "numero_Documento")
    @MapsId
    private Persona persona;
    private String tipo_Documento;
    private String nombre;
    private String nacionalidad;
    @ManyToOne
    @JoinColumn(name="direcciones", referencedColumnName = "id")
    private Direccion direcciones;
    private String direccionElectronica;
    private int telefono;
    private String palabraClave;
    private String tipoCliente;

    public Cliente(Persona persona, String tipoDocumento, String nombre, String nacionalidad,
    Direccion direccion, String direccionElectronica, int telefono, String palabraClave,
            String tipoCliente) {
        //this.id = id;
        this.persona = persona;
        this.tipo_Documento = tipoDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direcciones = direccion;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
        this.palabraClave = palabraClave;
        this.tipoCliente = tipoCliente;
    }
    public Cliente()
    {;}
    
    public int getNumero_Documento() {
        return numero_Documento;
    }
    public void setNumero_Documento(int numero_Documento) {
        this.numero_Documento = numero_Documento;
    }
    public String getTipo_Documento() {
        return tipo_Documento;
    }
    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
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
    public Direccion getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }
    public String getDireccionElectronica() {
        return direccionElectronica;
    }
    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getPalabraClave() {
        return palabraClave;
    }
    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    @Override
    public String toString() {
        return this.numero_Documento + "|" +
                this.tipo_Documento + "|" +
                this.nombre + "|" +
                this.nacionalidad + "|" +
                this.direcciones + "|" +
                this.direccionElectronica + "|" +
                this.telefono + "|" +
                this.palabraClave + "|" +
                this.tipoCliente;
}
}