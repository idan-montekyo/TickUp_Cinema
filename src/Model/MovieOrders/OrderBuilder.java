package Model.MovieOrders;

import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Screening;
import Model.Theaters.Tickets;

public class OrderBuilder {
    // Builder design pattern for UserOrder object:
    private UserOrder order;

    public OrderBuilder(){
        resetBuilder();
    }

    public void buildUserPhoneNumber(String phoneNumber){
        order.setUserPhoneNumber(phoneNumber);
    }

    public void buildMovie(Movie movie){
        order.setMovie(movie);
    }

    public void buildScreening(Screening screening){
        order.setScreening(screening);
    }

    public void buildTickets(Tickets tickets){
        order.setTickets(tickets);
    }

    public UserOrder getOrder(){
        UserOrder order = this.order;
        this.resetBuilder();
        return order;
    }

    private void resetBuilder(){
        order = new UserOrder();
    }
}
