package com.github.anth0o0ny.programming_lab5.baseclasses;

import com.github.anth0o0ny.programming_lab5.moviemaking.InputArgumentTester;



public enum Color {

    RED("Красный"),
    BLACK("Черный"),
    YELLOW("Желтый"),
    ORANGE("Оранжевый"),
    WHITE("Белый");

    private final String title;

    Color(String title) {
        this.title = title;
    }

    public static Color chooseColor() {
        InputArgumentTester iat = new InputArgumentTester();
        return iat.assignInputColor();

    }

    @Override
    public String toString() {
        return title;
    }
}
//enum of comandRegistration
// constant String(все стринги повестить в класс в соответсивии с переменными и передавать их в поля)
// packets(норм переимеовать, без подчеркиваний)