package com.serratec.domain.model;

import com.serratec.domain.Enum.Genero;

import java.time.LocalDate;

public class Revista extends ItensDeBiblioteca {
    private String periodicidade;

    public Revista(String titulo, String autor,
                   Genero genero, LocalDate dataDaPublicacao,
                   Double precoAluguel, boolean alugado,
                   String periodicidade) {
        super(titulo, autor, genero, dataDaPublicacao, precoAluguel, alugado);
        this.periodicidade = periodicidade;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
}
