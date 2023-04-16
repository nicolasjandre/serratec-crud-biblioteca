package com.serratec.domain.Enum;

public enum TipoDoItem {
    LIVRO("Livro"),
    TODOS("Todos"),
    ALUGADO("Alugado"),
    GIBI("Gibi"),
    REVISTA("Revista");

    private String value;

    TipoDoItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
