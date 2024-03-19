package uniandes.edu.co.proyecto.modelo;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "operacion_Bancaria")

public class OperacionBancaria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private java.sql.Timestamp hora;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="id_Origen", referencedColumnName = "id")
    private Producto id_Origen;
    @ManyToOne
    @JoinColumn(name="id_Destino", referencedColumnName = "id")
    private Producto id_Destino;
    @ManyToOne
    @JoinColumn(name="punto_de_Atencion", referencedColumnName = "id")
    private PuntoDeAtencion punto_de_Atencion;
    private int valor;
    private String tipo;
    public OperacionBancaria(Integer id, java.sql.Timestamp hora, Date fecha, Producto idOrigen, Producto idDestino,
            PuntoDeAtencion puntoAtencion,Integer valor, String tipo) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.id_Origen = idOrigen;
        this.id_Destino = idDestino;
        this.punto_de_Atencion = puntoAtencion;
        this.valor = valor;
        this.tipo = tipo;
    }
    public OperacionBancaria() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public java.sql.Timestamp getHora() {
        return hora;
    }
    public void setHora(java.sql.Timestamp hora) {
        this.hora = hora;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Producto getId_Origen() {
        return id_Origen;
    }
    public void setId_Origen(Producto id_Origen) {
        this.id_Origen = id_Origen;
    }
    public Producto getId_Destino() {
        return id_Destino;
    }
    public void setId_Destino(Producto id_Destino) {
        this.id_Destino = id_Destino;
    }
    public PuntoDeAtencion getPunto_de_Atencion() {
        return punto_de_Atencion;
    }
    public void setPunto_de_Atencion(PuntoDeAtencion punto_de_Atencion) {
        this.punto_de_Atencion = punto_de_Atencion;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}


