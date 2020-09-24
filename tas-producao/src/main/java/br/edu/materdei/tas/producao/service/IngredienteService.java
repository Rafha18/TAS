package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.producao.entity.IngredienteEntity;
import br.edu.materdei.tas.producao.repository.IngredienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Quadra
 */
@Service
public class IngredienteService implements IBaseService<IngredienteEntity> {
    
    private IngredienteRepository repository;

    @Override
    public List<IngredienteEntity> findAll() {
        
        return repository.findAll();  
    }

    @Override
    public IngredienteEntity findById(Integer id) throws ResourceNotFoundException {
        
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));    
    }

    @Override
    public IngredienteEntity save(IngredienteEntity entity) {
        
        return repository.saveAndFlush(entity);
       
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        
        repository.deleteById(id);
        
    }
    
}
