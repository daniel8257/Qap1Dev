package com.movierentalsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRentalSystemUnitTest {

    @Test
    void testAddMovieAndRent() {
        // Arrange
        MovieRentalSystem system = new MovieRentalSystem();
        Movie movie = new Movie("1", "Inception");

        // Act
        system.addMovie(movie);

        // Assert
        assertEquals(1, system.getAllMovies().size());
        assertTrue(system.rentMovie("1", "customer1"));
        assertFalse(movie.isAvailable());
    }

    @Test
    void testReturnMovie() {
        // Arrange
        MovieRentalSystem system = new MovieRentalSystem();
        Movie movie = new Movie("1", "Inception");
        system.addMovie(movie);
        system.rentMovie("1", "customer1");

        // Act & Assert
        assertTrue(system.returnMovie("1"));
        assertTrue(movie.isAvailable());
    }

    @Test
    void testRentUnavailableMovie() {
        // Arrange
        MovieRentalSystem system = new MovieRentalSystem();
        Movie movie = new Movie("1", "Inception");
        system.addMovie(movie);
        system.rentMovie("1", "customer1");

        // Act & Assert
        assertFalse(system.rentMovie("1", "customer2"));
    }
}
