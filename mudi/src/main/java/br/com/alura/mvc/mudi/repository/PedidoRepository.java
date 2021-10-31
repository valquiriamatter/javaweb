package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // vendo que é uma lista, ele já faz um select * from pedido, como o nome do método é findByStatus,
    // ele já sabe que é pra filtrar pelo atributo status.
    List<Pedido> findByStatus(StatusPedido status);
}
