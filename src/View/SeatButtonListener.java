package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatButtonListener implements ActionListener {
    private int row;
    private int col;

    SeatButtonListener(int row, int col){
        super();
        this.row = row;
        this.col = col;
    }

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
