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

        InputArgumentTester iat = new InputArgumentTester();
        long id = (long) (Math.random() * 1_000_000_000 + 1);

        String name = iat.assignInputName() ;
        Double x = iat.assignInputX();
        Float y = iat.assignInputY();
        Coordinates coordinates = new Coordinates(x, y);
        java.util.Date date = new Date();
        Long oscCount = iat.assignInputOscarCount();
        long budget = iat.assignInputBudget();
        String tagline = iat.assignTagline();
        MpaaRating rate = MpaaRating.chooseRating();
        Person person = Person.ctreatePerson();

        return new Movie(id, name, coordinates, date, oscCount, budget, tagline, rate, person);
    }
}
