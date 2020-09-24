package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.OrdemProducaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael Quadra
 */
@Repository
public interface OrdemProducaoRepository extends JpaRepository<OrdemProducaoEntity, Integer> {
    
}
