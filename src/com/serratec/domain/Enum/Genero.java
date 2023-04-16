package com.serratec.domain.Enum;

public enum Genero {
    FANTASIA("Fantasia"),
    FICCAO("Ficção"),
    ROMANCE("Romance"),
    ESTRATEGIA_MILITAR("Estratégia Militar"),
    POEMA_EPICO("Poema Épico"),
    CIENCIA("Ciência"),
    ACAO_E_AVENTURA("Ação e aventura"),
    MODA("Moda"),
    HUMOR("Humor"),
    VIAGENS("Viagens"),
    LITERATURA("Literatura"),
    MANGA("Mangá");

    private String value;

    Genero(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void imprimirGeneros() {
        int i = 1;

        for (Genero genero : Genero.values()) {
            System.out.printf("%d) " + genero.getValue() + "%n", i);
            i++;
        }
    }
}
