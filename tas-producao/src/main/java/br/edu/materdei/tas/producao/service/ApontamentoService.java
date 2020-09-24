package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.producao.entity.ApontamentoEntity;
import br.edu.materdei.tas.producao.repository.ApontamentoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Quadra
 */
@Service
public class ApontamentoService implements IBaseService<ApontamentoEntity> {
    
    private ApontamentoRepository repository;

    @Override
    public List<ApontamentoEntity> findAll() {
        
        return repository.findAll();  
    }

    @Override
    public ApontamentoEntity findById(Integer id) throws ResourceNotFoundException {
        
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));    
    }

    @Override
    public ApontamentoEntity save(ApontamentoEntity entity) {
        
        return repository.saveAndFlush(entity);
       
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        
        repository.deleteById(id);
        
    }
    
}
