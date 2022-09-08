package com.github.anth0o0ny.programming_lab5.baseclasses;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)

public class Movie implements Comparable<Movie> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private long budget; //Значение поля должно быть больше 0
    private String tagline; //Длина строки не должна быть больше 158, Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person screenwriter;


    public Movie(long id, String name, Coordinates coordinates, java.util.Date creationDate, Long oscarsCount,
                 long budget, String tagline, MpaaRating mpaaRating, Person screenwriter) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setOscarsCount(oscarsCount);
        setBudget(budget);
        setTagline(tagline);
        setMpaaRating(mpaaRating);
        setScreenwriter(screenwriter);
    }
    public Movie(){}



    @Override
    public int compareTo(Movie movie) {
        return (this.getName().compareTo(movie.getName()));
    }

    @Override
    public String toString() {
        return "Фильм: " + name + ", id = " + id;
    }

    public long getId() {
        return id;
    }

//    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

//    @XmlElement
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

//    @XmlElement
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

//    @XmlElement
    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public long getBudget() {
        return budget;
    }

//    @XmlElement
    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getTagline() {
        return tagline;
    }
//
//    @XmlElement
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

//    @XmlElement
    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Person getScreenwriter() {
        return screenwriter;
    }

//    @XmlElement
    public void setScreenwriter(Person screenwriter) {
        this.screenwriter = screenwriter;
    }
}

