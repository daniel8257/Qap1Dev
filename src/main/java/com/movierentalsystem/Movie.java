package com.movierentalsystem;

public class Movie {
    private String id;
    private String title;
    private boolean isAvailable;

    public Movie(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true; // Movies are available by default
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rentMovie() {
        this.isAvailable = false;
    }

    public void returnMovie() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
