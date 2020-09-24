package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.ApontamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Quadra
 */
public interface ApontamentoRepository extends JpaRepository<ApontamentoEntity, Integer>{
    
}
