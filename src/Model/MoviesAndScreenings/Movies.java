package Model.MoviesAndScreenings;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumTheaterType;
import Model.Enums.EnumWeekDays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Create a class that holds all the movies.
public class Movies {
    // Fields
    private final List<Movie> allMovies;

    // Constructor
    public Movies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }


    // Getter
    public List<Movie> getAllMovies() {
        return allMovies;
    }


    // Display all data about each movie at the cinema: Name, Duration and screening times
    public void displayMovies() {
        //Traversing list through Iterator
        Iterator itr = this.allMovies.iterator();//getting the Iterator
        while (itr.hasNext()) {//check if iterator has the elements
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println(itr.next());//printing the element and move to next
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
