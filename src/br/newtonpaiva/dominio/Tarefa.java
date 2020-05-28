
package br.newtonpaiva.dominio;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 4mti
 */
@Entity
@Table(name = "tb_tarefa")

public class Tarefa {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "tarefa_id")
    private Integer id;
    
    @Column (name = "nom_tarefa", nullable = false, unique = true)
    private String nome;
    
    @Column (name = "num_prioridade",nullable = false, length = 50) //Criando um padrão de nomeclatura de coluna
    private String prioridade;
    
    @Column(name = "num_percentual", nullable = false)
    private Integer percentual;
    
    @Column(name = "des_tarefa")
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dta_limite", nullable = false)
    private Calendar dataLimite;
    
    @Enumerated
    @Column(name = "tp_situacao", nullable = false)
    private Situacao situacao;
        
    
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Terefa{" + "id=" + id + ", nome=" + nome + '}';
    }

    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the percentual
     */
    public Integer getPercentual() {
        return percentual;
    }

    /**
     * @param percentual the percentual to set
     */
    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * @return the dataLimite
     */
    public Calendar getDataLimite() {
        return dataLimite;
    }

    /**
     * @param dataLimite the dataLimite to set
     */
    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
        
        Calendar hoje = Calendar.getInstance();
        
        if(dataLimite != null && dataLimite.before(hoje))
            throw new IllegalStateException("Data limite é menor que hoje.");
        this.dataLimite = dataLimite;
        return;
    }   

    /**
     * @return the situacao
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
        
    }
}
