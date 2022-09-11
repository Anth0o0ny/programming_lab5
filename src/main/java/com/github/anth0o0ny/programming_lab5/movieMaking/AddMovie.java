package com.github.anth0o0ny.programming_lab5.movieMaking;

import com.github.anth0o0ny.programming_lab5.baseclasses.Coordinates;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.baseclasses.MpaaRating;
import com.github.anth0o0ny.programming_lab5.baseclasses.Person;

import java.util.*;

public class AddMovie {

    public static String addMovie(Stack<Movie> collection) {
        Movie makingMovie = makeMovie();
        collection.push(makingMovie);
        return "Город добавлен в коллекцию";
    }

    public static String AddMovieIfMin(Stack<Movie> collection) {
        Movie makingMovie = makeMovie();
        if (makingMovie.compareTo(Collections.min(collection)) < 0) {
            collection.push(makingMovie);
            return "Город добавлен в коллекцию";
        } else {
            return "Город добавить не удалось";
        }
    }

    public static Movie makeMovie() {
        Scanner sc = new Scanner(System.in);
        long id = (long) (Math.random() * 1_000_000_000 + 1);

        String name;
        do{
            System.out.println("Введите название фильма: ");
            try{
                name = sc.nextLine();
                if (name.isEmpty() ) {
                    throw new RuntimeException();
                }
            }catch (RuntimeException ex){
                System.out.println("Значение поля \"name\" можeт быть равно null или быть пустым");
                name = null;
            }
        }while (name==null);


//
        Double x;
        do{
            System.out.println("Введите координату x: ");
            String inp = sc.nextLine();
            try{
                x = Double.parseDouble(inp);
                if (x > 398 ) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException ex){
                System.out.println("Коордната должна быть типа Doable и ее значение должно быть не более 398");
                x = null;
            }
        }while (x==null);


//        System.out.println("Введите координату y: ");
//        Float y = sc.nextFloat();
        Float y;
        do{
            System.out.println("Введите координату y: ");
            String inp = sc.nextLine();
            try{
                y = Float.parseFloat(inp);
            }catch (NumberFormatException ex){
                System.out.println("Коордната должна быть типа Float");
                y = null;
            }
        }while (y==null);

        Coordinates coordinates = new Coordinates(x, y);

        java.util.Date date = new Date();

//        System.out.println("Введтие количество оскаров, полученных фильмом: ");
//        Long oscCount = sc.nextLong();
        Long oscCount;
        do{
            System.out.println("Введтие количество оскаров, полученных фильмом: ");
            String inp = sc.nextLine();
            try{
                oscCount = Long.parseLong(inp);
                if (oscCount <= 0 ) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException ex){
                System.out.println("Количество оскаров должно быть типа Long и его значение должно быть больше 0");
                oscCount = null;
            }
        }while (oscCount==null);

//        System.out.println("Введите бюджет фильма: ");
//        long budget = sc.nextLong();
        long budget;
        do{
            System.out.println("Введите бюджет фильма: ");
            String inp = sc.nextLine();
            try{
                budget = Long.parseLong(inp);
                if (budget <= 0 ) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException ex){
                System.out.println("Количество оскаров должно быть long и его значение должно быть больше 0");
                budget = 0;
            }
        }while (budget==0);



//        System.out.println("Введие слоган фильма: ");
//        String tagline = sc.nextLine();

        String tagline;
        do{
            System.out.println("Введие слоган фильма: ");
            try{
                tagline = sc.nextLine();
                if (tagline.length() > 158) {
                    throw new RuntimeException();
                }
            }catch (RuntimeException ex){
                System.out.println("Длина поля \"tagline\"  не должна быть больше 158");
                tagline = null;
            }
        }while (tagline==null);

        MpaaRating rate = MpaaRating.chooseRating();

        Person person = Person.ctreatePerson();

        return new Movie(id, name, coordinates, date, oscCount, budget, tagline, rate, person);
    }
}
