package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Direccion;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (NUMERO_DOCUMENTO,TIPO_DOCUMENTO,NOMBRE,NACIONALIDAD,DIRECCIONES,DIRECCION_ELECTRONICA,TELEFONO,PALABRA_CLAVE,TIPO_CLIENTE) VALUES (:NUMERO_DOCUMENTO,:TIPO_DOCUMENTO,:NOMBRE,:NACIONALIDAD,:DIRECCIONES,:DIRECCION_ELECTRONICA,:TELEFONO,:PALABRA_CLAVE,:TIPO_CLIENTE)",nativeQuery = true)
    void insertarCliente(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO, @Param("TIPO_DOCUMENTO") String TIPO_DOCUMENTO, @Param("NOMBRE") String NOMBRE, @Param("NACIONALIDAD") String NACIONALIDAD,@Param("DIRECCIONES") String DIRECCIONES,@Param("DIRECCION_ELECTRONICA") String DIRECCION_ELECTRONICA,@Param("TELEFONO") String TELEFONO,@Param("PALABRA_CLAVE") String PALABRA_CLAVE, @Param("TIPO_CLIENTE") String TIPO_CLIENTE );

    @Query(value = "SELECT * FROM cliente", nativeQuery = true )
    Collection<Direccion> getClientes();

    @Query(value = "SELECT * FROM cliente WHERE NUMERO_DOCUMENTO = :NUMERO_DOCUMENTO", nativeQuery = true )
    Direccion getCliente(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO);

    @Modifying
    @Transactional
    @Query(value = "UPDATE INTO cliente TIPO_DOCUMENTO = :TIPO_DOCUMENTO,NOMBRE = :NOMBRE,NACIONALIDAD = :NACIONALIDAD,DIRECCIONES = :DIRECCIONES,DIRECCION_ELECTRONICA =:DIRECCION_ELECTRONICA ,TELEFONO = :TELEFONO, PALABRA_CLAVE = :PALABRA_CLAVE,TIPO_CLIENTE =:TIPO_CLIENTE)  WHERE NUMERO_DOCUMENTO = :NUMERO_DOCUMENTO",nativeQuery = true)
    void actualizarCliente(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO, @Param("TIPO_DOCUMENTO") String TIPO_DOCUMENTO, @Param("NOMBRE") String NOMBRE, @Param("NACIONALIDAD") String NACIONALIDAD,@Param("DIRECCIONES") String DIRECCIONES,@Param("DIRECCION_ELECTRONICA") String DIRECCION_ELECTRONICA,@Param("TELEFONO") String TELEFONO,@Param("PALABRA_CLAVE") String PALABRA_CLAVE, @Param("TIPO_CLIENTE") String TIPO_CLIENTE );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE NUMERO_DOCUMENTO =:NUMERO_DOCUMENTO", nativeQuery = true)
    void eliminarCliente(@Param("NUMERO_DOCUMENTO") Integer NUMERO_DOCUMENTO);


}
