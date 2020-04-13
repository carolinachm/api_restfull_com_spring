package br.com.springboot.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empresa")
@Data
@NoArgsConstructor
public class Empresa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name="razao_social", nullable = false)
    private String razaoSocial;
    @Getter @Setter
    @Column(name="cnpj", nullable = false)
    private String cnpj;
    @Getter @Setter
    @Column(name="data_criacao", nullable = false)
    private Date dataCriacao;
    @Getter @Setter
    @Column(name="data_atualizacao", nullable = false)
    private Date dataAtualizacao;
    @Getter @Setter
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = new Date();
    }
    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao =  atual;
    }
    
	



    

}