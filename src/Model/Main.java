package Model;

// Creating and initializing all the data.
public class Main {

    public static void main(String[] args) {

        Movies movieList = Movies.create_movie_list();
        Orders orderList = Orders.create_user_orders(movieList);

        movieList.displayMovies();
        orderList.displayOrders();
    }
}
