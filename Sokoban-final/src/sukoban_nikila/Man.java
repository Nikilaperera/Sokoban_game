package sukoban_nikila;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class Man extends Actions
{
    
    String name = "Sokoban";
    int moves = 0;
    int gameScore = 0;
    
     public Man(int x, int y)
    {
        super(x, y);

        URL loc = this.getClass().getResource("/images/player.png");
        ImageIcon imgIcon = new ImageIcon(loc);
        Image image = imgIcon.getImage();
        this.setImage(image);
    }
    
    public void move(int x, int y) 
    {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
        
        this.moves++;
    }

   
}

