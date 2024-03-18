package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM producto *", nativeQuery = true )
    Collection<Producto> getProductos();

    @Query(value = "SELECT * FROM producto WHERE id= :id", nativeQuery = true )
    Producto getProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto (id, cliente) VAlLUES(PRODUCTO_ID.nextval, cliente=:cliente)", nativeQuery = true )
    void insertarProducto(@Param("cliente") String cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET cliente = :cliente WHERE id =:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("cliente") String cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE id =:id", nativeQuery = true)
    void eliminarProducto(@Param("id") int id);
  
}
