package com.github.anth0o0ny.programming_lab5.baseclasses;

public enum Country {

    RUSSIA("Россия"),
    USA("США"),
    GERMANY("Германия"),
    ITALY("Италия"),
    NORTH_KOREA("Северная Корея");
    private final String title;
    Country(String title){this.title = title;}

    @Override
    public String toString() {return title ;}
}
