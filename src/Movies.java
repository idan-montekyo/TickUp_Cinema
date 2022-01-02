import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Movies {

    // Fields
    private List<Movie> allMovies = new ArrayList<Movie>();

    public Movies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public void displayMovies() {
        //Traversing list through Iterator
        Iterator itr = this.allMovies.iterator();//getting the Iterator
        while (itr.hasNext()) {//check if iterator has the elements
            System.out.println(itr.next());//printing the element and move to next
        }

    }
}
