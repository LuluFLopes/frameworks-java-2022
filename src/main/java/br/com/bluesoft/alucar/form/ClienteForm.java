package br.com.bluesoft.alucar.form;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Endereco;

import java.math.BigInteger;

public class ClienteForm {

    private Long id;
    private String nome;
    private BigInteger cpf;
    private String email;
    private BigInteger celular;
    private Endereco endereco;

    public Cliente converter(ClienteForm form) {
        return new Cliente(form);
    }

    public Cliente atualizar(Cliente cliente) {

        cliente.setClienteKey(this.getId());
        cliente.setNome(this.getNome());
        cliente.setCpf(this.getCpf());
        cliente.setEmail(this.getEmail());
        cliente.setCelular(this.getCelular());
        cliente.setEndereco(this.getEndereco());
        return cliente;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
