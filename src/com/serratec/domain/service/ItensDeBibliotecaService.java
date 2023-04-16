package com.serratec.domain.service;

import com.serratec.domain.Enum.Genero;
import com.serratec.domain.Enum.TipoDoItem;
import com.serratec.domain.model.Gibi;
import com.serratec.domain.model.ItensDeBiblioteca;
import com.serratec.domain.model.Livro;
import com.serratec.domain.model.Revista;
import com.serratec.domain.utils.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ItensDeBibliotecaService {

    public void buscarPorNome(List<ItensDeBiblioteca> itens) {
        Scanner s = new Scanner(System.in);
        String opcao;
        int i = 1;

        System.out.println("Digite o título do livro: ");
        opcao = s.nextLine().toLowerCase();

        Util.imprimirLinha();
        Util.imprimirCabecalho();
        Util.imprimirLinha();

        for (ItensDeBiblioteca item: itens) {
            if (item.getTitulo().toLowerCase().contains(opcao)) {
                System.out.printf("%-11s", i);
                item.imprimirItem();
                i++;
            }
        }
        Util.imprimirLinha();
        System.out.println("Pressione ENTER para voltar ao menu");
        s.nextLine();
    }
    public void menu(List<ItensDeBiblioteca> itens, ItensDeBibliotecaService service) {
        Scanner s = new Scanner(System.in);
        boolean continuar = true;
        boolean alugar = true;
        char opcao;

        do {
            Util.imprimirMenu();
            try {
                opcao = s.nextLine().charAt(0);
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                opcao = 'R';
            }

            switch (opcao) {
                case '1' -> service.menuCadastro(itens);
                case '2' -> service.consultarPorCategoria(itens);
                case '3' -> service.imprimirCatalogo(itens, TipoDoItem.ALUGADO);
                case '4' -> service.buscarPorNome(itens);
                case '5' -> service.alugarOuDevolverItem(itens, true);
                case '6' -> service.alugarOuDevolverItem(itens, false);
                case '7' -> System.out.println("Método não criado");
                case '8' -> System.out.println("Método não criado");
                case '0' -> {
                    System.out.println("Obrigado por nos visitar!");
                    continuar = false;
                }
                default -> {
                    System.out.println("Opção inválida, pressione ENTER para voltar ao menu.");
                    s.nextLine();
                }
            }

        } while (continuar);
    }
    public void imprimirCatalogo(List<ItensDeBiblioteca> itens, TipoDoItem tipo) {
        Scanner s = new Scanner(System.in);
        int i = 1;

        Util.imprimirLinha();
        System.out.printf("%52s %n", tipo.getValue().toUpperCase());
        Util.imprimirLinha();
        Util.imprimirCabecalho();

        for (ItensDeBiblioteca item : itens) {
            if (tipo == TipoDoItem.TODOS) {
                System.out.printf("%-11s", i);
                item.imprimirItem();
            } else if (tipo == TipoDoItem.ALUGADO) {
                if (item.isAlugado()) {
                    System.out.printf("%-11s", i);
                    item.imprimirItem();
                }
            } else if (item.getClass().getName().contains(tipo.getValue())) {
                System.out.printf("%-11s", i);
                item.imprimirItem();
            }
            i++;
        }
        Util.imprimirLinha();

        System.out.println("Pressione ENTER para voltar ao menu");
        s.nextLine();
    }
    public void consultarPorCategoria(List<ItensDeBiblioteca> itens) {
        Scanner s = new Scanner(System.in);
        char opcao;

        Util.imprimirMenuCategoria();

        try {
            opcao = s.nextLine().charAt(0);
        } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
            opcao = 'R';
        }

        switch (opcao) {
            case '1' -> imprimirCatalogo(itens, TipoDoItem.LIVRO);
            case '2' -> imprimirCatalogo(itens, TipoDoItem.GIBI);
            case '3' -> imprimirCatalogo(itens, TipoDoItem.REVISTA);
            default -> imprimirCatalogo(itens, TipoDoItem.TODOS);
        }
    }
    public void cadastrarItem(List<ItensDeBiblioteca> itens, TipoDoItem tipo) {
        String titulo, autor, ISBN, periodicidade, estiloDeArte, desenhista;
        boolean continua1, continua2, alugado = false;
        Scanner s = new Scanner(System.in);
        LocalDate dataDePublicacao = null;
        Genero genero = null;
        Double precoAluguel = 0.0;
        int opcao = 0;

        System.out.print("Título: ");
        titulo = s.nextLine();

        System.out.print("Autor: ");
        autor = s.nextLine();

        System.out.println("Gêneros: ");
        Genero.imprimirGeneros();

        do {
            continua1 = false;
            try {
                System.out.println("Digite um número de 1 a 12");
                opcao = s.nextInt();
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Digite um valor válido.");
                s.nextLine();
            }

        switch (opcao) {
            case 1 -> genero = Genero.FANTASIA;
            case 2 -> genero = Genero.FICCAO;
            case 3 -> genero = Genero.ROMANCE;
            case 4 -> genero = Genero.ESTRATEGIA_MILITAR;
            case 5 -> genero = Genero.POEMA_EPICO;
            case 6 -> genero = Genero.CIENCIA;
            case 7 -> genero = Genero.ACAO_E_AVENTURA;
            case 8 -> genero = Genero.MODA;
            case 9 -> genero = Genero.HUMOR;
            case 10 -> genero = Genero.VIAGENS;
            case 11 -> genero = Genero.LITERATURA;
            case 12 -> genero = Genero.MANGA;
            default -> continua1 = true;
        }
        } while (continua1);
        s.nextLine();

        do {
            try {
                System.out.println("Ano de publicação (YYYY/M/D):");
                String entrada = s.nextLine();
                String[] partes = entrada.split("/");
                int ano = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int dia = Integer.parseInt(partes[2]);
                dataDePublicacao = LocalDate.of(ano, mes, dia);
                continua2 = false;
            } catch (Exception e) {
                System.out.println("A data precisa ter o seguinte formato: YYYY/M/" +
                        "D");
                continua2 = true;
            }
        } while (continua2);

        do {
            try {
                System.out.print("Preço do aluguel: ");
                precoAluguel = Double.parseDouble(s.nextLine());
                continua2 = false;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
                continua2 = true;
            }
        } while (continua2);

        if (tipo == TipoDoItem.LIVRO) {
            System.out.print("ISBN: ");
            ISBN = s.nextLine();

            itens.add(new Livro(titulo, autor, genero, dataDePublicacao,
                    precoAluguel, alugado, ISBN));
        } else if (tipo == TipoDoItem.REVISTA) {
            System.out.print("Periodicidade :");
            periodicidade = s.nextLine();

            itens.add(new Revista(titulo, autor, genero, dataDePublicacao,
                    precoAluguel, alugado, periodicidade));
        } else {
            System.out.print("Desenhista: ");
            desenhista = s.nextLine();

            System.out.print("Estilo de arte: ");
            estiloDeArte = s.nextLine();

            itens.add(new Gibi(titulo, autor, genero, dataDePublicacao,
                    precoAluguel, alugado, desenhista, estiloDeArte));
        }

        Util.imprimirLinha();
        System.out.printf("%64s%n", "CADASTRADO COM SUCESSO");
        System.out.printf("%70s%n", "Pressione ENTER para voltar ao menu");
        Util.imprimirLinha();
        s.nextLine();
    }
    public void menuCadastro(List<ItensDeBiblioteca> itens) {
        Scanner s = new Scanner(System.in);
        char opcao;

        Util.imprimirMenuCadastro();

        try {
            opcao = s.nextLine().charAt(0);
        } catch (Exception e) {
            opcao = 'R';
        }

        switch (opcao) {
            case '1' -> cadastrarItem(itens, TipoDoItem.LIVRO);
            case '2' -> cadastrarItem(itens, TipoDoItem.REVISTA);
            case '3' -> cadastrarItem(itens, TipoDoItem.GIBI);
            default -> {
                System.out.println("""
                        Opção inválida.
                        Pressione ENTER para voltar ao menu.""");
                s.nextLine();
            }
        }
    }
    public void alugarOuDevolverItem(List<ItensDeBiblioteca> itens, boolean alugar) {
        List<ItensDeBiblioteca> itensMatch = new ArrayList<>();
        List<ItensDeBiblioteca> listaAlugado = new ArrayList<>();
        List<ItensDeBiblioteca> listaDisponivel = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String opcao;
        char opcao2;

        for (ItensDeBiblioteca item : itens) {
            if (item.isAlugado()) {
                listaAlugado.add(item);
            } else {
                listaDisponivel.add(item);
            }
        }

        if (!alugar && listaAlugado.size() == 0) {
            System.out.println("""
                    Não há itens para devolver.
                    Pressione ENTER para voltar ao menu.""");
            s.nextLine();
            return;
        } else if (alugar && listaDisponivel.size() == 0) {
            System.out.println("""
                    Não há itens disponíveis para alugar.
                    Pressione ENTER para voltar ao menu.""");
            s.nextLine();
            return;
        }

        do {
            int i = 1;
            if (itensMatch.size() > 1) {
                System.out.println("Seja mais específico no título para restar somente uma opção.");
                itensMatch = new ArrayList<>();
            }

            System.out.print("Digite o título do livro: (Deixe em branco para listar todos)");
            opcao = s.nextLine().toLowerCase();

            Util.imprimirLinha();
            Util.imprimirCabecalho();
            Util.imprimirLinha();

            for (ItensDeBiblioteca item : itens) {
                if (alugar && item.getTitulo().toLowerCase().contains(opcao) && !item.isAlugado()) {
                    itensMatch.add(item);
                    System.out.printf("%-11s", i);
                    item.imprimirItem();
                } else if (!alugar && item.getTitulo().toLowerCase().contains(opcao) && item.isAlugado()) {
                    itensMatch.add(item);
                    System.out.printf("%-11s", i);
                    item.imprimirItem();
                }
                i++;
            }
        } while (itensMatch.size() != 1);
        Util.imprimirLinha();

        ItensDeBiblioteca itemMatch = itensMatch.get(0);
        System.out.printf("%s, confirma? (S/N)", itemMatch.getTitulo());

        try {
            opcao2 = s.nextLine().toUpperCase().charAt(0);
        } catch (InputMismatchException e) {
            opcao2 = 'R';
        }

        switch (opcao2) {
            case 'S' -> {
                try {
                    if (alugar) {
                        itemMatch.setAlugado(true);
                        System.out.printf("Obrigado por alugar %s por apenas R$%.2f%n",
                                itemMatch.getTitulo(), itemMatch.getPrecoAluguel());
                    } else {
                        itemMatch.setAlugado(false);
                        System.out.printf("Obrigado por devolver %s. Agradecemos os cuidados com o material! %n",
                                itemMatch.getTitulo());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case 'N' -> {
                System.out.print("Pressione ENTER para voltar ao menu");
                s.nextLine();
            }
            default -> {
                System.out.print("Opção inválida, pressione ENTER para voltar ao menu");
                s.nextLine();
            }
        }

    }
}
