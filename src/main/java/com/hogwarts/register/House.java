package com.hogwarts.register;

public enum House {
    GRYFFINDOR("Gryffindor"),
    HUFFLEPUFF("Hufflepuff"),
    RAVENCLAW("Ravenclaw"),
    SLYTHERIN("Slytherin");

    private final String text;

    House(final String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
