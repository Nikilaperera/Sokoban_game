package sukoban_nikila;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class box extends Actions
{
    public void move(int x, int y) 
    {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }
    
    public box(int x, int y) 
    {
        super(x, y);
        
        URL loc = this.getClass().getResource("/images/box1.png");
        ImageIcon imgIcon = new ImageIcon(loc);
        Image image = imgIcon.getImage();
        this.setImage(image);
    }

    
}
