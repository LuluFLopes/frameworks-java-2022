package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class VendedorDto {

    private Long id;

    private String nome;
    private BigInteger cpf;
    private LocalDateTime dataAdmissao;
    private ContaCorrente cc;

    public VendedorDto(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.dataAdmissao = vendedor.getDataAdmissao();
        this.cc = vendedor.getCc();
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
}
