package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.IngredienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Quadra
 */
public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Integer>{
    
}
