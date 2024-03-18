package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    Collection<Cliente> getClientes();

    @Query(value = "SELECT * FROM CLIENTE WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    Cliente getClienteByNumeroDocumento(@Param("numeroDocumento") int numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENTE (NUMERO_DOCUMENTO, TIPO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCIONES, " +
            "DIRECCION_ELECTRONICA, TELEFONO, PALABRA_CLAVE, TIPO_CLIENTE) " +
            "VALUES(:numeroDocumento, :tipoDocumento, :nombre, :nacionalidad, :direcciones, " +
            ":direccionElectronica, :telefono, :palabraClave, :tipoCliente)", nativeQuery = true)
    void insertarCliente(@Param("numeroDocumento") int numeroDocumento, @Param("tipoDocumento") String tipoDocumento,
                         @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
                         @Param("direcciones") int direcciones, @Param("direccionElectronica") String direccionElectronica,
                         @Param("telefono") int telefono, @Param("palabraClave") String palabraClave,
                         @Param("tipoCliente") String tipoCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLIENTE SET TIPO_DOCUMENTO = :tipoDocumento, NOMBRE = :nombre, " +
            "NACIONALIDAD = :nacionalidad, DIRECCIONES = :direcciones, DIRECCION_ELECTRONICA = :direccionElectronica, " +
            "TELEFONO = :telefono, PALABRA_CLAVE = :palabraClave, TIPO_CLIENTE = :tipoCliente " +
            "WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    void actualizarCliente(@Param("numeroDocumento") int numeroDocumento, @Param("tipoDocumento") String tipoDocumento,
                           @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
                           @Param("direcciones") int direcciones, @Param("direccionElectronica") String direccionElectronica,
                           @Param("telefono") int telefono, @Param("palabraClave") String palabraClave,
                           @Param("tipoCliente") String tipoCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLIENTE WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    void eliminarCliente(@Param("numeroDocumento") int numeroDocumento);


}
