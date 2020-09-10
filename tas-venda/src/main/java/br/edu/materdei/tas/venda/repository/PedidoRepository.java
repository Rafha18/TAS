
package br.edu.materdei.tas.venda.repository;

import br.edu.materdei.tas.venda.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael Quadra
 */
@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{
    
}
