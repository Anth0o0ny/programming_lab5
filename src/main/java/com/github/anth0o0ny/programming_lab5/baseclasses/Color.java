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
        byte colorNum;
        Color res = null;

        do {
            System.out.println("Выберете цвет волос персонажа : ");
            for (byte i = 0; Color.values().length > i; i++) {
                System.out.println((i + 1) + ". " + Color.values()[i]);
            }
            String inp = sc.nextLine();
            try {
                colorNum = Byte.parseByte(inp);
                res = Color.values()[colorNum - 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующего цвета волос");
                colorNum = 0;
            } catch (NumberFormatException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующего цвета волос");
                colorNum = 0;
            }
        } while (colorNum == 0);

        return res;
    }

    @Override
    public String toString() {
        return title;
    }
}
