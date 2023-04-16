package com.serratec.domain.model;

import com.serratec.domain.Enum.Genero;

import java.time.LocalDate;

public class Livro extends ItensDeBiblioteca {
    private String ISBN;

    public Livro(String titulo, String autor,
                 Genero genero, LocalDate dataDaPublicacao,
                 Double precoAluguel, boolean alugado, String ISBN) {
        super(titulo, autor, genero, dataDaPublicacao, precoAluguel, alugado);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
