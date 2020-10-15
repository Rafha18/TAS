package br.edu.materdei.tas.estoque.aspect;

import br.edu.materdei.tas.compra.entity.CompraEntity;
import br.edu.materdei.tas.estoque.entity.EstoqueEntity;
import br.edu.materdei.tas.estoque.service.EstoqueService;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
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
    
    public void salvarVenda(){
    }
    
    public void excluirCompra(){
    }
    
    public void excluirVenda(){
    }
    
}
