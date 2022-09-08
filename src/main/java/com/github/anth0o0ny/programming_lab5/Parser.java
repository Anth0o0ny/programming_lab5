package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Stack;

public class Parser {
    static StringBuilder sb = new StringBuilder();
    static String res;

    public static void parsing(Stack<Movie> collection) {

        File file = new File("movie.xml");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            int symb;
            while ((symb = bis.read()) != -1) {
                sb.append((char) symb);
            }
            String fileStr = sb.toString();
            res = fileStr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(MoviesCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MoviesCollection moviesCollection = (MoviesCollection) jaxbUnmarshaller.unmarshal(new StringReader(res));

            for (Movie movie : moviesCollection.getCollection()) {
                collection.push(movie);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
