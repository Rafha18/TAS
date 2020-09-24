package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.producao.entity.ProdutoAcabadoEntity;
import br.edu.materdei.tas.producao.repository.ProdutoAcabadoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Quadra
 */
@Service
public class ProdutoAcabadoService implements IBaseService<ProdutoAcabadoEntity> {
    
    private ProdutoAcabadoRepository repository;

    @Override
    public List<ProdutoAcabadoEntity> findAll() {
        
        return repository.findAll();  
    }

    @Override
    public ProdutoAcabadoEntity findById(Integer id) throws ResourceNotFoundException {
        
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));    
    }

    @Override
    public ProdutoAcabadoEntity save(ProdutoAcabadoEntity entity) {
        
        return repository.saveAndFlush(entity);
       
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        
        repository.deleteById(id);
        
    }
    
}
