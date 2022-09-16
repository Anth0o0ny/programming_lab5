package com.github.anth0o0ny.programming_lab5.moviemaking;

import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.Color;
import com.github.anth0o0ny.programming_lab5.baseclasses.Country;
import com.github.anth0o0ny.programming_lab5.baseclasses.MpaaRating;

import java.util.Scanner;

public class InputArgumentTester {

    Scanner sc = new Scanner(System.in);

    protected String assignInputName() {
        String name;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_MOVIE_NAME);
            try {
                name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_NAME);
                name = null;
            }
        } while (name == null);
        return name;
    }

    protected Double assignInputX() {
        Double x;
        do {
            System.out.println( StringConstants.MovieMaking.ENTER_COORDINATE + " x: ");
            String inp = sc.nextLine();
            try {
                x = Double.parseDouble(inp);
                if (x > 398) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_X_COORDINATE);
                x = null;
            }
        } while (x == null);
        return x;
    }

    protected Float assignInputY() {
        Float y;
        do {
            System.out.println( StringConstants.MovieMaking.ENTER_COORDINATE + " y: ");
            String inp = sc.nextLine();
            try {
                y = Float.parseFloat(inp);
            } catch (NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_Y_COORDINATE);
                y = null;
            }
        } while (y == null);
        return y;
    }

    protected Long assignInputOscarCount() {
        Long oscCount;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_OSCAR_COUNT);
            String inp = sc.nextLine();
            try {
                oscCount = Long.parseLong(inp);
                if (oscCount <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_OSCAR_COUNT);
                oscCount = null;
            }
        } while (oscCount == null);
        return oscCount;
    }

    protected long assignInputBudget() {
        long budget;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_BUDGET);
            String inp = sc.nextLine();
            try {
                budget = Long.parseLong(inp);
                if (budget <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_BUDGET);
                budget = 0;
            }
        } while (budget == 0);
        return budget;
    }

    protected String assignTagline() {
        String tagline;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_TAGLINE);
            try {
                tagline = sc.nextLine();
                if (tagline.length() > 158) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_TAGLINE);
                tagline = null;
            }
        } while (tagline == null);
        return tagline;
    }

    public MpaaRating assignMpaaRating() {
        byte rateNum;
        MpaaRating res = null;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_MPAA_RATING);
            for (byte i = 0; MpaaRating.values().length > i; i++) {
                System.out.println((i + 1) + ". " + MpaaRating.values()[i]);
            }
            String inp = sc.nextLine();

            try {
                rateNum = Byte.parseByte(inp);
                res = MpaaRating.values()[rateNum - 1];
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_MPAA_RATING);
                rateNum = 0;
            }
        }
        while (rateNum == 0);
        return res;
    }

    public String assignInputPersonName(){
        String name;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_PERSON_NAME);
            try {
                name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_PERSON_NAME);
                name = null;
            }
        } while (name == null);
        return name;
    }

    public float assignInputHeight(){
        float height;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_HEIGHT);
            String inp = sc.nextLine();
            try {
                height = Float.parseFloat(inp);
                if (height <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_HEIGHT);
                height = 0;
            }
        } while (height == 0);
        return height;
    }

    public Country assignInputCountry(){
        byte countryNum;
        Country res = null;
        do {
            System.out.println(StringConstants.MovieMaking.ENTER_COUNTRY);
            for (byte i = 0; Country.values().length > i; i++) {
                System.out.println((i + 1) + ". " + Country.values()[i]);
            }
            String inp = sc.nextLine();
            try {
                countryNum = Byte.parseByte(inp);
                res = Country.values()[countryNum - 1];
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_COUNTRY);
                countryNum = 0;
            }
        }
        while (countryNum == 0);
        return res;
    }
    public Color assignInputColor(){
        byte colorNum;
        Color res = null;

        do {
            System.out.println(StringConstants.MovieMaking.ENTER_COLOR);
            for (byte i = 0; Color.values().length > i; i++) {
                System.out.println((i + 1) + ". " + Color.values()[i]);
            }
            String inp = sc.nextLine();
            try {
                colorNum = Byte.parseByte(inp);
                res = Color.values()[colorNum - 1];
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println(StringConstants.MovieMaking.WRONG_COLOR);
                colorNum = 0;
            }
        } while (colorNum == 0);
        return res;
    }

}


