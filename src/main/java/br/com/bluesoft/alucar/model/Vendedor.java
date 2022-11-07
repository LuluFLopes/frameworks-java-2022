package br.com.bluesoft.alucar.model;

import br.com.bluesoft.alucar.form.VendedorForm;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vendedor_key")
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigInteger cpf;

    //@Column(nullable = false)
    private LocalDateTime dataAdmissao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ContaCorrente cc;

    @OneToMany(mappedBy = "vendedor")
    private List<Aluguel> aluguel;

    public Vendedor() {
    }

    public Vendedor(VendedorForm form) {

        this.id = form.getId();
        this.nome = form.getNome();
        this.cpf = form.getCpf();
        this.dataAdmissao = form.getDataAdmissao();
        this.cc = form.getCc();

    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataAdmissao=" + dataAdmissao +
                ", cc=" + cc +
                ", aluguel=" + aluguel +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDateTime dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public ContaCorrente getCc() {
        return cc;
    }

    public void setCc(ContaCorrente cc) {
        this.cc = cc;
    }

    public List<Aluguel> getAluguel() {
        return aluguel;
    }

    public void setAluguel(List<Aluguel> aluguel) {
        this.aluguel = aluguel;
    }
}
