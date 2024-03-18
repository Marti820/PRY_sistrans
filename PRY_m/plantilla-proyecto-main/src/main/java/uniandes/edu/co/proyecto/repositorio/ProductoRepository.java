package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
    Collection<Producto> getProductos();

    @Query(value = "SELECT * FROM PRODUCTO WHERE ID = :id", nativeQuery = true)
    Producto getProductoById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRODUCTO (ID, CLIENTE) VALUES (PRODUCTO_ID.nextval, :cliente)", nativeQuery = true)
    void insertProducto(@Param("cliente") Long cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUCTO SET CLIENTE = :cliente WHERE ID = :id", nativeQuery = true)
    void updateProductoCliente(@Param("id") Long id, @Param("cliente") Long cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRODUCTO WHERE ID = :id", nativeQuery = true)
    void deleteProducto(@Param("id") Long id);
  
}
