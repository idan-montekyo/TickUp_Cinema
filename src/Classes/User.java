package Classes;

public class User {
    private boolean[][] theaterMatrix; // True - available, False - Occupied
    int rows;
    int cols;

    // Constructor
    public User(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        theaterMatrix = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.theaterMatrix[row][col] = true;
            }
        }
    }

    // Display all movies
    public void displayMoviesForSelection(Movies movies){
        movies.displayMovies();
    }

    // Select a valid seat
    public void selectSeat(int row, int col){
        if(this.theaterMatrix[row][col] = true && (row < this.rows && this.rows > 0) && (col < this.cols && this.cols > 0)) {
            this.theaterMatrix[row][col] = false;
            System.out.println("Seats has selected!");
        }
        else {
            System.out.println(("This seat is occupied or illegal!"));
        }
    }

    // User movie selection
    public Movie selectMovie(Movies movieList, int MovieNumber){
        return movieList.getAllMovies().get(MovieNumber);
    }

}
