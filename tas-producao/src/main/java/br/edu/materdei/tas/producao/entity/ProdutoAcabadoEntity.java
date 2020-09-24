package br.edu.materdei.tas.producao.entity;

import br.edu.materdei.tas.core.entity.ProdutoEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rafael Quadra
 */
@Entity
@Table(name = "produtoacabado")
public class ProdutoAcabadoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 90)
    private String produto;
    
    @Column(nullable = false, length = 90)
    private String ingrediente;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoEntity produtos;

    public ProdutoAcabadoEntity() {
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the ingrediente
     */
    public String getIngrediente() {
        return ingrediente;
    }

    /**
     * @param ingrediente the ingrediente to set
     */
    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * @return the produtos
     */
    public ProdutoEntity getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(ProdutoEntity produtos) {
        this.produtos = produtos;
    }

    
    
    
}
