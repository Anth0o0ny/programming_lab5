package com.github.anth0o0ny.programming_lab5.baseclasses;

import java.util.Scanner;

public enum MpaaRating {

    G("Нет возрастных ограничений"),
    PG("Рекомендуется присутсттвие родителей"),
    PG_13("Детям до 13 лет просмотр не желателен"),
    R("Лицам до 17 лет обязательно присутствие взрослого"),
    NC_17("Лицам до 18 лет просмотр запрещен");

    private final String title;

    MpaaRating(String title) {
        this.title = title;
    }

    public static MpaaRating chooseRating() {

        Scanner sc = new Scanner(System.in);
        byte rateNum;
        MpaaRating res = null;
        do {
            System.out.println("Выберете рейтинг фильма : ");
            for (byte i = 0; MpaaRating.values().length > i; i++) {
                System.out.println((i + 1) + ". " + MpaaRating.values()[i]);
            }
            String inp = sc.nextLine();

            try {
                rateNum = Byte.parseByte(inp);
                res = MpaaRating.values()[rateNum - 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующего рейтинга");
                rateNum = 0;
            } catch (NumberFormatException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующего рейтинга");
                rateNum = 0;
            }
        }
        while (rateNum == 0);
        return res;
    }

    @Override
    public String toString() {
        return title;
    }
}
