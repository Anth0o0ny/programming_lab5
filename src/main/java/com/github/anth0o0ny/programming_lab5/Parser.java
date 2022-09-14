package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.movieMaking.AddMovie;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Stack;

public class Parser {
    static StringBuilder sb = new StringBuilder();
    static String res;


    public static void parsingToObj(Stack<Movie> collection, String pathToFile) {

        File file = new File(pathToFile);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            int symb;
            while ((symb = bis.read()) != -1) {
                sb.append((char) symb);
            }
            res = sb.toString();
        } catch (IOException e) {
            System.out.println("Файл с входной коллекцией не найден или недостаточно прав.");;
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(MoviesCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MoviesCollection moviesCollection = (MoviesCollection) jaxbUnmarshaller.unmarshal(new StringReader(res));

            for (Movie movie : moviesCollection.getCollection()) {
                collection.push(movie);
            }
            AddMovie.setIdGenerator(new IdGenerator(moviesCollection.getCollection()));
//
        } catch (JAXBException e) {
            System.out.println("Не удалось распарсить");;
        }
    }

    public static void parsingToXml(MoviesCollection moviesCollection){
        try {

                JAXBContext context = JAXBContext.newInstance(MoviesCollection.class);
                Marshaller mar = context.createMarshaller();
                mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                mar.marshal(moviesCollection, new FileOutputStream("movie.xml"));



        }catch(JAXBException | FileNotFoundException x){
            System.out.println("Файл не найден.");;
            }
    }


}
