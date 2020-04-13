package br.com.springboot.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.springboot.enums.PerfilEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Data
@NoArgsConstructor
public class Funcionario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name="nome", nullable = false)
    private String nome; 
    @Getter @Setter
    @Column(name="email", nullable = false)
    private String email;
    @Getter @Setter
    @Column(name="senha", nullable = false)
    private String senha;
    @Getter @Setter
    @Column(name="cpf", nullable = false)
    private String cpf;
    @Getter @Setter
    @Column(name="data_atualizacao", nullable = false)
    private BigDecimal valorHora;
    @Getter @Setter
    @Column(name="qtdHorasTrabalhadaDia", nullable = false)
    private Float qtdHorasTrabalhadaDia;
    @Getter @Setter
    @Column(name="qtdHorasAlmoco", nullable = false)
    private Float qtdHorasAlmoco;
    @Getter @Setter
    private PerfilEnum perfil;
    @Getter @Setter
    private Date dataCriacao;
    @Getter @Setter
    private Date dataAtualizacao;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa empresa;
    @Getter @Setter
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private transient List<Lancamento> lancamentos;

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
