package br.com.bluesoft.alucar.form;

import br.com.bluesoft.alucar.model.Carro;

public class CarroForm {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
    private Integer quilometragem;
    private Double diaria;

    public Carro converter(CarroForm form) {
        return new Carro(form);
    }

    public Carro atualizar(Carro carro) {
        carro.setId(getId());
        carro.setPlaca(getPlaca());
        carro.setMarca(getMarca());
        carro.setModelo(getModelo());
        carro.setCor(getCor());
        carro.setAno(getAno());
        carro.setQuilometragem(getQuilometragem());
        carro.setDiaria(getDiaria());
        return carro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Double getDiaria() {
        return diaria;
    }

    public void setDiaria(Double diaria) {
        this.diaria = diaria;
    }
}
