package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Seat button listener class
public class SeatButtonListener implements ActionListener {
    // New fields to know which seat was clicked
    private int row;
    private int col;

    // Constructor
    SeatButtonListener(int row, int col){
        super();
        this.row = row;
        this.col = col;
    }

    // Getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }
}
