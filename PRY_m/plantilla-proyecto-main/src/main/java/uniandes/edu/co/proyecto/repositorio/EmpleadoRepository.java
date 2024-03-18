package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADO (NUMERO_DOCUMENTO,TIPO_DOCUMENTO,NOMBRE,NACIONALIDAD,DIRECCIONES,DIRECCION_ELECTRONICA,TELEFONO,PALABRA_CLAVE,OFICINA,SUELDO,TIPO_CLIENTE) VALUES (:NUMERO_DOCUMENTO,:TIPO_DOCUMENTO,:NOMBRE,:NACIONALIDAD,:DIRECCIONES,:DIRECCION_ELECTRONICA,:TELEFONO,:PALABRA_CLAVE,:OFICINA ,:SUELDO , :TIPO_CLIENTE)",nativeQuery = true)
    void insertarEmpleado(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO, @Param("TIPO_DOCUMENTO") String TIPO_DOCUMENTO, @Param("NOMBRE") String NOMBRE, @Param("NACIONALIDAD") String NACIONALIDAD,@Param("DIRECCIONES") String DIRECCIONES,@Param("DIRECCION_ELECTRONICA") String DIRECCION_ELECTRONICA,@Param("TELEFONO") String TELEFONO,@Param("PALABRA_CLAVE") String PALABRA_CLAVE,@Param("OFICINA") String OFICINA,@Param("SUELDO") String SUELDO, @Param("TIPO_CLIENTE") String TIPO_CLIENTE );

    @Query(value = "SELECT * FROM EMPLEADO", nativeQuery = true )
    Collection<Direccion> getEmpleados();

    @Query(value = "SELECT * FROM EMPLEADO WHERE NUMERO_DOCUMENTO = :NUMERO_DOCUMENTO", nativeQuery = true )
    Direccion getEmpleado(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO);

    @Modifying
    @Transactional
    @Query(value = "UPDATE INTO EMPLEADO TIPO_DOCUMENTO = :TIPO_DOCUMENTO,NOMBRE = :NOMBRE,NACIONALIDAD = :NACIONALIDAD,DIRECCIONES = :DIRECCIONES,DIRECCION_ELECTRONICA =:DIRECCION_ELECTRONICA ,TELEFONO = :TELEFONO, PALABRA_CLAVE = :PALABRA_CLAVE,OFICINA =:OFICINA,SUELDO=:SUELDO,TIPO_CLIENTE =:TIPO_CLIENTE)  WHERE NUMERO_DOCUMENTO = :NUMERO_DOCUMENTO",nativeQuery = true)
    void actualizarEmpleado(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO, @Param("TIPO_DOCUMENTO") String TIPO_DOCUMENTO, @Param("NOMBRE") String NOMBRE, @Param("NACIONALIDAD") String NACIONALIDAD,@Param("DIRECCIONES") String DIRECCIONES,@Param("DIRECCION_ELECTRONICA") String DIRECCION_ELECTRONICA,@Param("TELEFONO") String TELEFONO,@Param("PALABRA_CLAVE") String PALABRA_CLAVE,@Param("OFICINA") String OFICINA,@Param("SUELDO") String SUELDO, @Param("TIPO_CLIENTE") String TIPO_CLIENTE );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EMPLEADO WHERE NUMERO_DOCUMENTO =:NUMERO_DOCUMENTO", nativeQuery = true)
    void eliminarEmpleado(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO);


}

