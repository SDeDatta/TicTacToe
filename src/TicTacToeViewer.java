import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    public final int WINDOW_WIDTH = 500;
    public final int WINDOW_HEIGHT = 500;
    public final int SQUARE_LENGTH = 100;

    public TicTacToe t;
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }
    public void drawAxes(Graphics g)
    {
        String zero = "0";
        String one = "1";
        String two = "2";
        g.setColor(Color.BLACK);
        g.drawString(zero, 150, 75);
        g.drawString(one, 250, 75);
        g.drawString(two, 350, 75);

        g.drawString(zero, 75, 150);
        g.drawString(one, 75, 250);
        g.drawString(two, 75, 350);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        drawAxes(g);
        for(int i = 0; i < t.getBoard().length; i++)
        {
            for(int j = 0; j < t.getBoard()[i].length; j++)
            {
                t.getBoard()[i][j].draw(g);
            }
        }

        String winner = t.getWinner();
        if(!winner.equals(""))
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD,30));
            g.drawString(winner + " Wins", 180, 450);
        }
    }
}
