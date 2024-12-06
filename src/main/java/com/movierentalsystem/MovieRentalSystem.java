package com.movierentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieRentalSystem {

    private List<Movie> movies;
    private List<Customer> customers;

    // Constructor
    public MovieRentalSystem() {
        this.movies = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Add a movie to the system
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Add a customer to the system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Rent a movie to a customer
    public boolean rentMovie(String movieId, String customerId) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equals(movieId) && m.isAvailable())
                .findFirst();

        if (movie.isPresent()) {
            movie.get().rentMovie();
            return true;
        }
        return false;
    }

    // Return a movie
    public boolean returnMovie(String movieId) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equals(movieId) && !m.isAvailable())
                .findFirst();

        if (movie.isPresent()) {
            movie.get().returnMovie();
            return true;
        }
        return false;
    }

    // Get a list of all movies
    public List<Movie> getAllMovies() {
        return movies;
    }

    // Main method for testing the program
    public static void main(String[] args) {
        // Create the MovieRentalSystem instance
        MovieRentalSystem system = new MovieRentalSystem();

        // Add a customer
        Customer customer = new Customer("1", "John Doe");
        system.addCustomer(customer);
        System.out.println("Added customer: " + customer);

        // Add a movie to the system
        Movie movie = new Movie("1", "Inception");
        system.addMovie(movie);
        System.out.println("Added movie: " + movie);

        // Rent the movie
        boolean rented = system.rentMovie("1", "1");
        System.out.println("Movie rented successfully: " + rented);

        // Return the movie
        boolean returned = system.returnMovie("1");
        System.out.println("Movie returned successfully: " + returned);

        // Show all movies in the system
        System.out.println("Current movies in the system: " + system.getAllMovies());
    }
}
