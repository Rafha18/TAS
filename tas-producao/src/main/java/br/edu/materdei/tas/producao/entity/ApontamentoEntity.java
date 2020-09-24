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
@Table(name = "apontamento")
public class ApontamentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private OrdemProducaoEntity ordemproducao;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dtapontamento;
    
    @Column(nullable = false, length = 10)
    private Integer qtdade;

    public ApontamentoEntity() {
        this.dtapontamento = new Date();
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
     * @return the ordemproducao
     */
    public OrdemProducaoEntity getOrdemproducao() {
        return ordemproducao;
    }

    /**
     * @param ordemproducao the ordemproducao to set
     */
    public void setOrdemproducao(OrdemProducaoEntity ordemproducao) {
        this.ordemproducao = ordemproducao;
    }

    /**
     * @return the dtapontamento
     */
    public Date getDtapontamento() {
        return dtapontamento;
    }

    /**
     * @param dtapontamento the dtapontamento to set
     */
    public void setDtapontamento(Date dtapontamento) {
        this.dtapontamento = dtapontamento;
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
