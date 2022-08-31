package com.github.anth0o0ny.programming_lab5.baseclasses;

import java.util.Scanner;

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

    public static Color chooseColore() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберете цвет волос персонажа : ");

        for (byte i = 0; Color.values().length > i; i++) {
            System.out.println((i + 1) + ". " + Color.values()[i]);
        }

        byte colorNum = sc.nextByte();
        return Color.values()[colorNum - 1];
    }

    @Override
    public String toString() {
        return title;
    }
}
