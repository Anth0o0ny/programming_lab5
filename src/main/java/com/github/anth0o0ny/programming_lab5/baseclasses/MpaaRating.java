package com.github.anth0o0ny.programming_lab5.baseclasses;

import java.util.Scanner;

public enum MpaaRating {

    G("Нет возрастных ограничений"),
    PG("Рекомендуется присутсттвие родителей"),
    PG_13("Детям до 13 лет просмотр не желателен"),
    R("Лицам до 17 лет обязательно присутствие взрослого"),
    NC_17("Лицам до 18 лет просмотр запрещен");

    private final String title;
    MpaaRating(String title){this.title = title;}

    public static MpaaRating chooseRating(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете рейтинг фильма : ");
        for (byte i = 0; MpaaRating.values().length > i ; i++){
            System.out.println((i + 1) + ". " + MpaaRating.values()[i]);
        }
        byte rateNum = sc.nextByte();
        return MpaaRating.values()[rateNum - 1];
    }

    @Override
    public String toString() {return title ;}
}
