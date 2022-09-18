package com.github.anth0o0ny.programming_lab5.moviemaking;

import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.Coordinates;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.baseclasses.MpaaRating;
import com.github.anth0o0ny.programming_lab5.baseclasses.Person;

import java.util.*;

public class AddMovie {

    private static IdGenerator idGenerator;
    public static void setIdGenerator(IdGenerator idGenerator){
        AddMovie.idGenerator = idGenerator;
    }

    public static String addMovie(Stack<Movie> collection) {
        Movie makingMovie = makeMovie();
        collection.push(makingMovie);
        return StringConstants.MovieMaking.ADD_SUCCESS;
    }

    public static String AddMovieIfMin(Stack<Movie> collection) {
        Movie makingMovie = makeMovie();
        if (makingMovie.compareTo(Collections.min(collection)) < 0) {
            collection.push(makingMovie);
            return StringConstants.MovieMaking.ADD_SUCCESS;
        } else {
            return StringConstants.MovieMaking.ADD_FAIL;
        }
    }

    public static Movie makeMovie() {

        InputArgumentTester iat = new InputArgumentTester();

        long id = idGenerator.generateId();
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
