package sukoban_nikila;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class gem extends Actions
{
    public gem(int x, int y)
    {
        super(x, y);
        
        URL loc = this.getClass().getResource("/images/gem.png");
        ImageIcon imgIcon = new ImageIcon(loc);
        Image image = imgIcon.getImage();
        this.setImage(image);
    }
}
