package br.edu.materdei.tas.producao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rafael Quadra
 */
@Entity
@Table(name = "ingredientes")
public class IngredienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 70)
    private String produto;
    
    @Column(nullable = false, length = 10)
    private Integer qtdade;

    public IngredienteEntity() {
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
     * @return the qtdade
     */
    public Integer getQtdade() {
        return qtdade;
    }

    /**
     * @param qtdade the qtdade to set
     */
    public void setQtdade(Integer qtdade) {
        this.qtdade = qtdade;
    }
    
    
    
    
    
}
