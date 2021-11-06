package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // vendo que é uma lista, ele já faz um select * from pedido, como o nome do método é findByStatus,
    // ele já sabe que é pra filtrar pelo atributo status.
    @Cacheable("books") //habilitar o cache
    List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusUser(@Param("status")StatusPedido statusPedido, @Param("username") String username);
}
