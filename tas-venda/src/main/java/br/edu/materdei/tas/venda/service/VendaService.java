package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.PedidoEntity;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import br.edu.materdei.tas.venda.repository.PedidoRepository;
import br.edu.materdei.tas.venda.repository.VendaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rafael Quadra
 */
@Service
public class VendaService implements IBaseService<VendaEntity> {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    @Transactional
    public List<VendaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public VendaEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public VendaEntity save(VendaEntity entity) {
        
        VendaEntity ultimo = this.repository.findFirstByOrderByCodigoDesc();
        
        Integer codigo = (ultimo == null) ? 0 : Integer.valueOf(ultimo.getCodigo());
        codigo++;
        
        entity.setCodigo(String.format("%06d", codigo));
        
        VendaEntity salvo = repository.saveAndFlush(entity);
        
        PedidoEntity pedido = salvo.getPedido();
        pedido.setDtfaturado(new Date());
        
        pedidoRepository.save(pedido);
        
        return salvo;
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
        
        VendaEntity venda = this.findById(id);
        
        repository.deleteById(id);
        
        PedidoEntity pedido = venda.getPedido();
        pedido.setDtfaturado(null);
    }

}
