package br.com.bluesoft.alucar.model;

import br.com.bluesoft.alucar.form.ClienteForm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteKey;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigInteger cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private BigInteger celular;

    @OneToMany(mappedBy = "cliente")
    private List<Aluguel> listaAluguel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name="endereco.endereco_key")
    //@JoinColumn(name = "id", referencedColumnName = "id")
    //@JoinTable(name="endereco", joinColumns = {@JoinColumn(name = "cliente_key", referencedColumnName = "id")})
    private Endereco endereco;

    public Cliente(ClienteForm form) {
        this.nome = form.getNome();
        this.cpf = form.getCpf();
        this.email = form.getEmail();
        this.celular = form.getCelular();
        this.endereco = form.getEndereco();
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + clienteKey +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                ", celular=" + celular +
                ", listaAluguel=" + listaAluguel +
                ", endereco=" + endereco +
                '}';
    }

    public Long getClienteKey() {
        return clienteKey;
    }

    public void setClienteKey(Long clienteKey) {
        this.clienteKey = clienteKey;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public List<Aluguel> getListaAluguel() {
        return listaAluguel;
    }

    public void setListaAluguel(List<Aluguel> listaAluguel) {
        this.listaAluguel = listaAluguel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
