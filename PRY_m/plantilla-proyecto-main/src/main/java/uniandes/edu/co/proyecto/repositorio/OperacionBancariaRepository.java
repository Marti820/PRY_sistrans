package uniandes.edu.co.proyecto.repositorio;


    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionBancaria;

import java.security.Timestamp;
import java.sql.Date;
import java.util.Collection;
    
    @Repository
    public interface OperacionBancariaRepository extends JpaRepository<OperacionBancaria, Integer> {
    
        @Query(value = "SELECT * FROM OPERACION_BANCARIA", nativeQuery = true)
        Collection<OperacionBancaria> getOperacionesBancarias();
    
        @Query(value = "SELECT * FROM OPERACION_BANCARIA WHERE ID = :id", nativeQuery = true)
        OperacionBancaria getOperacionBancaria(@Param("id") Integer id);
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO OPERACION_BANCARIA (ID, HORA, FECHA, ID_ORIGEN, PUNTO_DE_ATENCION, VALOR, TIPO, ID_DESTINO) " +
                "VALUES(:id, :hora, :fecha, :idOrigen, :puntoDeAtencion, :valor, :tipo, :idDestino)", nativeQuery = true)
        void insertarOperacionBancaria(@Param("id") Integer id, @Param("hora") Timestamp hora, @Param("fecha") Date fecha,
                                       @Param("idOrigen") Integer idOrigen, @Param("puntoDeAtencion") Integer puntoDeAtencion,
                                       @Param("valor") Double valor, @Param("tipo") String tipo, @Param("idDestino") Integer idDestino);
    
        @Modifying
        @Transactional
        @Query(value = "UPDATE OPERACION_BANCARIA SET HORA = :hora, FECHA = :fecha, ID_ORIGEN = :idOrigen, " +
                "PUNTO_DE_ATENCION = :puntoDeAtencion, VALOR = :valor, TIPO = :tipo, ID_DESTINO = :idDestino " +
                "WHERE ID = :id", nativeQuery = true)
        void actualizarOperacionBancaria(@Param("id") Integer id, @Param("hora") Timestamp hora, @Param("fecha") Date fecha,
                                         @Param("idOrigen") Integer idOrigen, @Param("puntoDeAtencion") Integer puntoDeAtencion,
                                         @Param("valor") Double valor, @Param("tipo") String tipo, @Param("idDestino") Integer idDestino);
    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM OPERACION_BANCARIA WHERE ID = :id", nativeQuery = true)
        void eliminarOperacionBancaria(@Param("id") Integer id);
    }


