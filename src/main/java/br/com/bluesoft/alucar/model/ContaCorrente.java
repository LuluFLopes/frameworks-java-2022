package br.com.bluesoft.alucar.model;

import javax.persistence.*;

@Entity
@Table(name="conta_corrente")
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="conta_corrente_key")
    private Long id;
    @Column(nullable = false)
    private String banco;
    @Column(nullable = false)
    private Integer agencia;
    @Column(nullable = false)
    private Integer conta;

//    @OneToOne(mappedBy = "cc")
//    private Vendedor vendedor;

    public Long getId() {
        return id;
    }

    public String getBanco() {
        return banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getConta() {
        return conta;
    }
}
