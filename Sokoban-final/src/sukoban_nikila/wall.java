package sukoban_nikila;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class wall extends Actions
{
    private Image image;

    public wall(int x, int y) 
    {
        super(x, y);

        URL wallurl = this.getClass().getResource("/images/wall.png");
        ImageIcon imgIcon = new ImageIcon(wallurl);
        image = imgIcon.getImage();
        this.setImage(image);
    }
}
