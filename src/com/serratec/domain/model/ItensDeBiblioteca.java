package com.serratec.domain.model;

import com.serratec.domain.Enum.Genero;

import java.time.LocalDate;

public abstract class ItensDeBiblioteca {
    private String titulo;
    private String autor;
    private Genero genero;
    private LocalDate dataDaPublicacao;
    private Double precoAluguel;
    private boolean alugado;

    public ItensDeBiblioteca(String titulo, String autor,
                             Genero genero, LocalDate dataDaPublicacao,
                             Double precoAluguel, boolean alugado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.dataDaPublicacao = dataDaPublicacao;
        this.precoAluguel = precoAluguel;
        this.alugado = alugado;
    }

    public void imprimirItem() {
        System.out.printf("%-40s %-25s %-20s R$%.2f %n",
                titulo, autor, (alugado ? "Alugado" : "Disponível"),
                getPrecoAluguel());
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataDaPublicacao() {
        return dataDaPublicacao;
    }

    public void setDataDaPublicacao(LocalDate dataDaPublicacao) {
        this.dataDaPublicacao = dataDaPublicacao;
    }

    public Double getPrecoAluguel() {
        return precoAluguel * (this.getClass().getName() == "Livro" ? 1.5 : 1.2);
    }

    public void setPrecoAluguel(Double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}
