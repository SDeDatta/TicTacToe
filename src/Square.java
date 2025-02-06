import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToeViewer game;
    private int gameWidth;
    private int gameHeight;
    private Image xImage;
    private Image oImage;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer game) {
        this.game = game;
        this.gameWidth = game.getWidth();
        this.gameHeight= game.getHeight();
        this.row = row;
        this.col = col;
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        String winner = game.t.getWinner();
        if(!winner.equals(""))
        {
            if(this.marker.equals("X"))
            {
                g.setColor(Color.GREEN);
                g.fillRect(game.SQUARE_LENGTH * (col + 1), game.SQUARE_LENGTH * (row + 1), game.SQUARE_LENGTH, game.SQUARE_LENGTH);
            }
            else if(this.marker.equals("O"))
            {
                g.setColor(Color.RED);
                g.fillRect(game.SQUARE_LENGTH * (col + 1), game.SQUARE_LENGTH * (row + 1), game.SQUARE_LENGTH, game.SQUARE_LENGTH);
            }
        }



        g.setColor(Color.BLACK);
        g.drawRect(game.SQUARE_LENGTH * (col + 1), game.SQUARE_LENGTH * (row + 1), game.SQUARE_LENGTH, game.SQUARE_LENGTH);
        if(this.marker.equals("X")) {
            g.setColor(Color.BLACK);
            g.drawImage(xImage, (col+1)*100 + 10, (row+1)*100 + 10, 80, 80, game);

        }
        else if(this.marker.equals("O"))
        {
            g.setColor(Color.BLACK);
            g.drawImage(oImage, (col+1)*100 + 10, (row+1)*100+ 10, 80, 80, game);
        }

    }
}

