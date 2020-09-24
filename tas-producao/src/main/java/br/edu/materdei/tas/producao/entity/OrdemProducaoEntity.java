package br.edu.materdei.tas.producao.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rafael Quadra
 */
@Entity
@Table(name = "ordemproducao")
public class OrdemProducaoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dtabertura;
    
    @Column(nullable = false, length = 10)
    private Integer qtdade;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoAcabadoEntity produtoacb;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dtfinalizado;

    public OrdemProducaoEntity() {
        this.dtabertura = new Date();
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
     * @return the dtabertura
     */
    public Date getDtabertura() {
        return dtabertura;
    }

    /**
     * @param dtabertura the dtabertura to set
     */
    public void setDtabertura(Date dtabertura) {
        this.dtabertura = dtabertura;
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

    /**
     * @return the produtoacb
     */
    public ProdutoAcabadoEntity getProdutoacb() {
        return produtoacb;
    }

    /**
     * @param produtoacb the produtoacb to set
     */
    public void setProdutoacb(ProdutoAcabadoEntity produtoacb) {
        this.produtoacb = produtoacb;
    }

    /**
     * @return the dtfinalizado
     */
    public Date getDtfinalizado() {
        return dtfinalizado;
    }

    /**
     * @param dtfinalizado the dtfinalizado to set
     */
    public void setDtfinalizado(Date dtfinalizado) {
        this.dtfinalizado = dtfinalizado;
    }
    
    
    
}
