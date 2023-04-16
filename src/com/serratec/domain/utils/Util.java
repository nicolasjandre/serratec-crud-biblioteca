package com.serratec.domain.utils;

public class Util {
    public static final void imprimirLinha() {
        System.out.println("_ ".repeat(53));
    }

    public static final void imprimirCabecalho() {
        System.out.printf("%-10s %-40s %-25s %-20s %s %n",
                "CÓDIGO", "TÍTULO", "AUTOR", "ALUGADO", "PREÇO");
    }

    public static final void imprimirMenu() {
        System.out.println("""
                Bem vindo a bibilioteca!
                1) Cadastrar item
                2) Listar itens por categoria
                3) Listar itens alugados
                4) Buscar item pelo título
                5) Alugar item
                6) Devolver item
                7) Deletar item
                8) Atualizar item
                0) Sair do programa
                Opção: """);
    }

    public static final void imprimirMenuCategoria() {
        System.out.println("""
                        1) Consultar Livros
                        2) Consultar Gibis
                        3) Consultar Revistas
                        #) Consultar Todos
                        Opção: """);
    }

    public static final void imprimirMenuCadastro() {
        System.out.println("""
                1) Cadastrar Livro
                2) Cadastrar Revista
                3) Cadastrar Gibi""");
    }
}
