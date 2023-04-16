package com.serratec;

import com.serratec.domain.model.ItensDeBiblioteca;
import com.serratec.domain.repository.ItensDeBibliotecaRepository;
import com.serratec.domain.service.ItensDeBibliotecaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var repository = new ItensDeBibliotecaRepository();
        var service = new ItensDeBibliotecaService();
        List<ItensDeBiblioteca> itens = repository.getItensDeBiblioteca();

        service.menu(itens, service);
    }
}