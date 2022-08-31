package com.github.anth0o0ny.programming_lab5.movieMaking;

import com.github.anth0o0ny.programming_lab5.baseclasses.Coordinates;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.baseclasses.MpaaRating;
import com.github.anth0o0ny.programming_lab5.baseclasses.Person;

import java.util.*;

public class AddMovie {

    public static String addMovie(Stack<Movie> collection){
        Movie makingMovie = makeMovie();
        collection.push(makingMovie);
        return "Город добавлен в коллекцию";
    }

    public static String AddMovieIfMin(Stack<Movie> collection){
        Movie makingMovie = makeMovie();
        if (makingMovie.compareTo(Collections.min(collection)) < 0){
            collection.push(makingMovie);
            return "Город добавлен в коллекцию";
        } else {
            return "Город добавить не удалось";
        }
    }

    public static Movie makeMovie(){
        Scanner sc = new Scanner(System.in);
        long id = (long) (Math.random() * 1_000_000_000 + 1);

        System.out.println("Введите название фильма: ");
        String name = sc.nextLine();

        System.out.println("Введите координату x: ");
        Double x = sc.nextDouble();
        System.out.println("Введите координату y: ");
        Float y = sc.nextFloat();
        Coordinates coordinates = new Coordinates(x,y);

        java.util.Date date = new Date();

        System.out.println("Введтие количество оскаров, полученных фильмом: ");
        Long oscCount = sc.nextLong();

        System.out.println("Введите бюджет фильма: ");
        long budget = sc.nextLong();

        System.out.println("Введие слоган фильма: ");
        String tagline = sc.nextLine();

        MpaaRating rate = MpaaRating.chooseRating();

        Person person = Person.ctreatePerson();

        return new Movie(id, name, coordinates, date, oscCount, budget, tagline, rate, person);
    }
}
