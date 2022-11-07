package br.com.bluesoft.alucar.form;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class VendedorForm {

    private Long id;

    private String nome;
    private BigInteger cpf;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dataAdmissao;
    private ContaCorrente cc;

    public Vendedor converter(VendedorForm form) {
        return new Vendedor(form);
    }

    public Vendedor atualizar (Vendedor vendedor) {

        vendedor.setId(this.getId());
        vendedor.setNome(this.getNome());
        vendedor.setCpf(this.getCpf());
        vendedor.setDataAdmissao(LocalDateTime.now());
        vendedor.setCc(this.getCc());
        return vendedor;

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
