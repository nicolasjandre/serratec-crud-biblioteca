package com.serratec.domain.model;

import com.serratec.domain.Enum.Genero;

import java.time.LocalDate;

public class Gibi extends ItensDeBiblioteca {
    private String desenhista;
    private String estiloDeArte;

    public Gibi(String titulo, String autor,
                Genero genero, LocalDate dataDaPublicacao,
                Double precoAluguel, boolean alugado,
                String desenhista, String estiloDeArte) {
        super(titulo, autor, genero, dataDaPublicacao, precoAluguel, alugado);
        this.desenhista = desenhista;
        this.estiloDeArte = estiloDeArte;
    }

    public String getDesenhista() {
        return desenhista;
    }

    public void setDesenhista(String desenhista) {
        this.desenhista = desenhista;
    }

    public String getEstiloDeArte() {
        return estiloDeArte;
    }

    public void setEstiloDeArte(String estiloDeArte) {
        this.estiloDeArte = estiloDeArte;
    }
}
