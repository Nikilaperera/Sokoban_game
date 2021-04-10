

package sukoban_nikila;

import javax.swing.*;
import java.awt.*;

public class SokobanMain extends JFrame
{
    
    private final int OFFSET = 50;

    public SokobanMain() 
    {
        Map();
    }
    
    public void Map() 
    {    
               
        Floor board = new Floor();
        add(board);
        board.setBackground(Color.YELLOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(board.getBoardWidth() + OFFSET, board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Sokoban Game");
    }
    
    public static void main(String[] args)
    {
        new SokobanMain();
    }
    
}

