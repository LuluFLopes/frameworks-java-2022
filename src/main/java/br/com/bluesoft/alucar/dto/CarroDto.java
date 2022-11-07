package br.com.bluesoft.alucar.dto;


import br.com.bluesoft.alucar.model.Carro;

public class CarroDto {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
    private Integer quilometragem;
    private Double diaria;

    public CarroDto(Carro carro) {
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.ano = carro.getAno();
        this.quilometragem = carro.getQuilometragem();
        this.diaria = carro.getDiaria();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public Double getDiaria() {
        return diaria;
    }
}
