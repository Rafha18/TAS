package br.edu.materdei.tas.estoque.aspect;

import br.edu.materdei.tas.compra.entity.CompraEntity;
import br.edu.materdei.tas.compra.service.CompraService;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.estoque.entity.EstoqueEntity;
import br.edu.materdei.tas.estoque.service.EstoqueService;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rafael Quadra
 */

@Aspect
@Component
public class EstoqueAspect {
    
    @Autowired
    private EstoqueService service;
    
    @Autowired
    private CompraService compraService;
    
    @Autowired
    private EntityManager entityManager;
    
    @AfterReturning(pointcut = "execution( * br.edu.materdei.tas.compra.service.CompraService.save(..))")
    public void salvarCompra(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        CompraEntity compra = (CompraEntity) args[0];
        
        compra.getItens().forEach(item -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade());
            estoque.setHistorico("Movimento de Entrada Originado Pela Compra "+ compra.getCodigo());
            
            this.service.save(estoque);
        });
        
    }
    
    @AfterReturning(pointcut = "execution( * br.edu.materdei.tas.venda.service.VendaService.save(..))")
    public void salvarVenda(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        VendaEntity venda = (VendaEntity) args[0];
        
        venda.getPedido().getItens().forEach(item -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade()*-1);
            estoque.setHistorico("Movimento de Saida Originado Pela Venda "+ venda.getCodigo());
            
            this.service.save(estoque);
        });
        
    }
    
     @Before("execution( * br.edu.materdei.tas.compra.service.CompraService.delete(..))")
    public void excluirCompra(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Integer id = (Integer) args[0];
        
        try {
            CompraEntity compra = this.compraService.findById(id);
            
            compra.getItens().forEach(item -> {
                
                EstoqueEntity estoque = new EstoqueEntity();
                
                estoque.setProduto(item.getProduto());
                estoque.setQtdade(item.getQtdade()*-1);
                estoque.setHistorico("Movimento de Saída Originado pelo Estorno da Compra "+ compra.getCodigo());
                
                this.service.save(estoque);
                
            });
            
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(EstoqueAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @AfterReturning(pointcut = "execution( * br.edu.materdei.tas.venda.service.VendaService.delete(..))")
    public void excluirVenda(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Integer id = (Integer) args[0];
        
        VendaEntity venda = this.entityManager.getReference(VendaEntity.class, id);
        
        venda.getPedido().getItens().forEach(item -> {
            EstoqueEntity estoque = new EstoqueEntity();
            
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade());
            estoque.setHistorico("Movimento de Entrada Originado Pelo Estorno da Venda "+ venda.getCodigo());
            
            this.service.save(estoque);
        });
    }
    
}
