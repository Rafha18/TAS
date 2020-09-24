package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.producao.entity.OrdemProducaoEntity;
import br.edu.materdei.tas.producao.repository.OrdemProducaoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Quadra
 */
@Service
public class OrdemProducaoService implements IBaseService<OrdemProducaoEntity> {
    
    private OrdemProducaoRepository repository;

    @Override
    public List<OrdemProducaoEntity> findAll() {
        
        return repository.findAll();  
    }

    @Override
    public OrdemProducaoEntity findById(Integer id) throws ResourceNotFoundException {
        
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));    
    }

    @Override
    public OrdemProducaoEntity save(OrdemProducaoEntity entity) {
        
        return repository.saveAndFlush(entity);
       
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        
        repository.deleteById(id);
        
    }
    
}
