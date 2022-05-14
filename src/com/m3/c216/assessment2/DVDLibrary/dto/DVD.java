package com.m3.c216.assessment2.DVDLibrary.dto;

import java.util.Objects;

public class DVD {

    /** INSTANCE VARIABLES */
    private final String title;
    private String releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String userRating;

    /** CONSTRUCTOR */
    public DVD(String title){
        this.title = title;
    }

    /** SETTERS AND GETTERS */
    public String getTitle(){
        return title;
    }


    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getMpaaRating(){
        return mpaaRating;
    }
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public String getStudio(){
        return studio;
    }
    public void setStudio(String studio){
        this.studio = studio;
    }
    public String getUserRating(){
        return userRating;
    }
    public void setUserRating(String userRating){
        this.userRating = userRating;
    }



    /** OVERRIDING EQUALS AND HASHCODE */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && Objects.equals(mpaaRating, dvd.mpaaRating) && Objects.equals(director, dvd.director) && Objects.equals(studio, dvd.studio) && Objects.equals(userRating, dvd.userRating);
    }


    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, mpaaRating, director, studio, userRating);
    }

   /** OVERRIDING TO STRING */
    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", userRating='" + userRating + '\'' +
                '}';
    }
}


