package com.github.anth0o0ny.programming_lab5.baseclasses;

import java.util.Scanner;

public enum Country {

    RUSSIA("Россия"),
    USA("США"),
    GERMANY("Германия"),
    ITALY("Италия"),
    NORTH_KOREA("Северная Корея");

    private final String title;

    Country(String title) {
        this.title = title;
    }

    public static Country chooseCountry() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберете гражданство персонажа : ");

        for (byte i = 0; Country.values().length > i; i++) {
            System.out.println((i + 1) + ". " + Country.values()[i]);
        }

        byte countryNum = sc.nextByte();
        return Country.values()[countryNum - 1];

    }

    @Override
    public String toString() {
        return title;
    }
}
