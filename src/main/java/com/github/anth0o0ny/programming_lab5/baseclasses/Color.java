package com.github.anth0o0ny.programming_lab5.baseclasses;

public enum Color {

    RED("Красный"),
    BLACK("Черный"),
    YELLOW("Желтый"),
    ORANGE("Оранжевый"),
    WHITE("Белый");

    private final String title;
    Color(String title){this.title = title;}

    @Override
    public String toString() {return title ;}
}
