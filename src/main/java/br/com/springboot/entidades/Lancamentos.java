package br.com.springboot.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_lancamento")
@Data
@NoArgsConstructor
public class Lancamentos implements Serializable{



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Getter 
    @Setter
	@Column(name = "data", nullable = false)
    private Date data;
    @Getter 
    @Setter
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Getter 
    @Setter
    @Column(name = "localizacao", nullable = true)
    private String localizacao;
    @Column(name = "data_criacao", nullable = false)
    @Getter 
    @Setter
    private Date dataCriacao;
    @Column(name = "data_atualizacao", nullable = false)
    @Getter 
    @Setter
    private Date dataAtualizacao;
    @Getter 
    @Setter
    @Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
    private TipoEnum tipo;
    @Getter 
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;
    
    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

}