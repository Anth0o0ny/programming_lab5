package com.github.anth0o0ny.programming_lab5.baseclasses;

public enum Color {

    RED("Ярость"),
    BLACK("Страх"),
    YELLOW("Расслабление"),
    ORANGE("Юмор"),
    WHITE("Любовь");

    private final String title;
    Color(String title){this.title = title;}

    @Override
    public String toString() {return title ;}
}
