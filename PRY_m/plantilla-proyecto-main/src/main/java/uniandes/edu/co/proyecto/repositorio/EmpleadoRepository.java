package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer>{
    @Query(value = "SELECT * FROM EMPLEADO", nativeQuery = true)
    Collection<Empleado> getEmpleados();

    @Query(value = "SELECT * FROM EMPLEADO WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    Empleado getEmpleadoByNumeroDocumento(@Param("numeroDocumento") Integer numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADO (NUMERO_DOCUMENTO, TIPO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCIONES, " +
            "DIRECCION_ELECTRONICA, TELEFONO, PALABRA_CLAVE, OFICINA, SUELDO, TIPO_EMPLEADO) " +
            "VALUES(:numeroDocumento, :tipoDocumento, :nombre, :nacionalidad, :direcciones, :direccionElectronica, " +
            ":telefono, :palabraClave, :oficina, :sueldo, :tipoEmpleado)", nativeQuery = true)
    void insertarEmpleado(@Param("numeroDocumento") int numeroDocumento, @Param("tipoDocumento") String tipoDocumento,
                          @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
                          @Param("direcciones") Integer direcciones, @Param("direccionElectronica") String direccionElectronica,
                          @Param("telefono") Integer telefono, @Param("palabraClave") String palabraClave,
                          @Param("oficina") String oficina, @Param("sueldo") Integer sueldo, @Param("tipoEmpleado") String tipoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE EMPLEADO SET TIPO_DOCUMENTO = :tipoDocumento, NOMBRE = :nombre, NACIONALIDAD = :nacionalidad, " +
            "DIRECCIONES = :direcciones, DIRECCION_ELECTRONICA = :direccionElectronica, TELEFONO = :telefono, " +
            "PALABRA_CLAVE = :palabraClave, OFICINA = :oficina, SUELDO = :sueldo, TIPO_EMPLEADO = :tipoEmpleado " +
            "WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    void actualizarEmpleado(@Param("numeroDocumento") Integer numeroDocumento, @Param("tipoDocumento") String tipoDocumento,
                            @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
                            @Param("direcciones") Integer direcciones, @Param("direccionElectronica") String direccionElectronica,
                            @Param("telefono") Integer telefono, @Param("palabraClave") String palabraClave,
                            @Param("oficina") String oficina, @Param("sueldo") Integer sueldo, @Param("tipoEmpleado") String tipoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EMPLEADO WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    void eliminarEmpleado(@Param("numeroDocumento") Integer numeroDocumento);


}


