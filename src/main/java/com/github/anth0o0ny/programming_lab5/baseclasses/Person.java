package com.github.anth0o0ny.programming_lab5.baseclasses;

import javax.xml.bind.annotation.XmlElement;
import java.util.Scanner;

public class Person {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private float height; //Значение поля должно быть больше 0
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, float height, Color hairColor, Country nationality) {
        setName(name);
        setHeight(height);
        setHairColor(hairColor);
        setNationality(nationality);
    }

    public Person() {
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    @XmlElement
    public void setHeight(float height) {
        this.height = height;
    }

    public Color getHairColor() {
        return hairColor;
    }

    @XmlElement
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    @XmlElement
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public static Person ctreatePerson() {

        Scanner sc = new Scanner(System.in);

//        System.out.println("Введите имя персонажа: ");
//        String name = sc.nextLine();
        String name;
        do {
            System.out.println("Введите имя персонажа: ");
            try {
                name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException ex) {
                System.out.println("Значение поля \"name\" можeт быть равно null или быть пустым");
                name = null;
            }
        } while (name == null);

//        System.out.println("Введите рост персонажа: ");
//        float height = sc.nextFloat();
        float height;
        do {
            System.out.println("Введите рост персонажа: ");
            String inp = sc.nextLine();
            try {
                height = Float.parseFloat(inp);
                if (height <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("Количество оскаров должно быть long и его значение должно быть больше 0");
                height = 0;
            }
        } while (height == 0);

        Color color = Color.chooseColore();

        Country country = Country.chooseCountry();

        return new Person(name, height, color, country);
    }
}
