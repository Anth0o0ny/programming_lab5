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
        byte countryNum;
        Country res = null;
        do {
            System.out.println("Выберете гражданство персонажа : ");
            for (byte i = 0; Country.values().length > i; i++) {
                System.out.println((i + 1) + ". " + Country.values()[i]);
            }
            String inp = sc.nextLine();
            try {
                countryNum = Byte.parseByte(inp);
                res = Country.values()[countryNum - 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующей страны");
                countryNum = 0;
            } catch (NumberFormatException ex) {
                System.out.println("Должно быть введен порядковый номер соответсвующей страны");
                countryNum = 0;
            }
        }
        while (countryNum == 0);
        return res;

    }

    @Override
    public String toString() {
        return title;
    }

}
