package com.serratec.domain.repository;

import com.serratec.domain.Enum.Genero;
import com.serratec.domain.model.Gibi;
import com.serratec.domain.model.ItensDeBiblioteca;
import com.serratec.domain.model.Livro;
import com.serratec.domain.model.Revista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItensDeBibliotecaRepository {
    private List<ItensDeBiblioteca> itensDeBiblioteca = new ArrayList<>();

    public ItensDeBibliotecaRepository() {
        itensDeBiblioteca.add(new Livro("Harry Potter", "J.K. Rowling",
                Genero.FANTASIA, LocalDate.of(1997, 7, 20),
                19.90, false, "4823743265723"));
        itensDeBiblioteca.add(new Revista("National Geographic", "Jane Goodall",
                Genero.CIENCIA, LocalDate.of(2022, 1, 1),
                2.99, false, "Mensal"));
        itensDeBiblioteca.add(new Gibi("Batman: O Cavaleiro das Trevas", "Frank Miller",
                Genero.ACAO_E_AVENTURA, LocalDate.of(1986, 2, 25),
                7.99, false, "David Mazzucchelli", "Realista"));
    }

    public List<ItensDeBiblioteca> getItensDeBiblioteca() {
        return itensDeBiblioteca;
    }

    public void adicionarItemDeBiblioteca(ItensDeBiblioteca item) {
        this.itensDeBiblioteca.add(item);
    }
}
