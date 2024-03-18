
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Producto producto;

    private String estado;
    private String tipo;
    private Double interes;
    private Integer cuotas;
    private Double valor_Cuota;
    private Integer monto;
    private String dia_Corte;
    private Double saldo_Pendiente;
    public Prestamo(Producto producto, String estado, String tipo, Double interes, Integer cuotas, Double valor_Cuota,
            Integer monto, String dia_Corte, Double saldo_Pendiente) {
        //this.id = id;
        //this.id = id;
        this.estado = estado;
        this.tipo = tipo;
        this.interes = interes;
        this.cuotas = cuotas;
        this.valor_Cuota = valor_Cuota;
        this.monto = monto;
        this.dia_Corte = dia_Corte;
        this.saldo_Pendiente = saldo_Pendiente;
    }
    
    public Prestamo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Double getValor_Cuota() {
        return valor_Cuota;
    }

    public void setValor_Cuota(Double valor_Cuota) {
        this.valor_Cuota = valor_Cuota;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getDia_Corte() {
        return dia_Corte;
    }

    public void setDia_Corte(String dia_Corte) {
        this.dia_Corte = dia_Corte;
    }

    public Double getSaldo_Pendiente() {
        return saldo_Pendiente;
    }

    public void setSaldo_Pendiente(Double saldo_Pendiente) {
        this.saldo_Pendiente = saldo_Pendiente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}

        
