
package sukoban_nikila;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Floor extends JPanel implements ActionListener 
{
    private final int OFFSET = 1;
    private final int SPACE = 60;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;
    
    
    private final ArrayList<wall> Wall = new ArrayList(); 
    private final ArrayList<box> box = new ArrayList(); 
    private final ArrayList<gem> gem = new ArrayList(); 
    
    private Man player; 
    private int w = 0;
    private int h = 0;
    private boolean completed = false;
    private boolean inGame = false;
    
     
    private String playerName = "Sokoban Player";
    private boolean hasPlayerName = false;
    
    
    Timer timer;
    int time = 0;
    
    private String level1 =   "                    \n"
                            + "                    \n"
                            + "                    \n"
                            + "       ########     \n"
                            + "      ##    ###     \n"
                            + "     ###      #     \n"
                            + "     ##    @  #     \n"
                            + "     ## $##.  #     \n"
                            + "     ## $  .###     \n"
                            + "     ##     ###     \n"
                            + "     ##########     \n"
                            + "                    \n"
                            + "                    \n"
                            + "                    \n";
                            
    
    private String level2 =   "                    \n"
                            + "                    \n"
                            + "                    \n"
                            + "        #######     \n"
                            + "      ###   #####   \n"
                            + "     ####$.  @  #   \n"
                            + "     ##   #     #   \n"
                            + "     ##  $.   ###   \n"
                            + "     ##  #    #     \n"
                            + "     ##  #    #     \n"
                            + "     ##########     \n"
                            + "                    \n"
                            + "                    \n"
                            + "                    \n";
    
    
    private String level3 =   "                    \n"
                            + "                    \n"
                            + "                    \n"
                            + "    ###########     \n"
                            + "    ###    ######   \n"
                            + "   ####.##$ #####   \n"
                            + "   ### ..$  #####   \n"
                            + "   ###  #$  #####   \n"
                            + "   ###  @ #######   \n"
                            + "   ##############   \n"
                            + "   ##############   \n"
                            + "                    \n"
                            + "                    \n"
                            + "                    \n";
                            
    
    private String level4 =   "                    \n"
                            + "                    \n"
                            + "        #########   \n"
                            + "   #######.   ###   \n"
                            + "   ###  #..## ###   \n"
                            + "   ###  $..   ###   \n"
                            + "   ### $# .# ####   \n"
                            + "   ####@##$#  ###   \n"
                            + "   ## $    $$ ###   \n"
                            + "   ## # #  #  ###   \n"
                            + "   ##   #########   \n"
                            + "    #####           \n"
                            + "                    \n"
                            + "                    \n";
    
    private String level5 =   "                    \n"
                            + "                    \n"
                            + "                    \n"
                            + "    ############    \n"
                            + "   ## ##. ..## #    \n"
                            + "   ### #. $.# ##    \n"
                            + "   # ####  $### #   \n"
                            + "   ## # $  $ # ##   \n"
                            + "   # ## #$## ## #   \n"
                            + "   ## #   @  # ##   \n"
                            + "   ####### ######   \n"
                            + "   ##############   \n"
                            + "                    \n"
                            + "                    \n";
    
    private String level6 =   "                    \n"
                            + "                    \n"
                            + "  #########         \n"
                            + "  #      ####       \n"
                            + "  # $$   ########   \n"
                            + "  #  $ $$$ ######   \n"
                            + "  ## ## ...    ###  \n"
                            + "   # #@#...###$ ##  \n"
                            + "   # # $...     ##  \n"
                            + "  ## # $...$ # ###  \n"
                            + "  #  ##### ### ###  \n"
                            + "  #      $   $ ###  \n"
                            + "  ###########  ###  \n"
                            + "            ###     \n";
    
    
    int currentLevel = 0;
    String[] levels = { level1, level2, level3, level4, level5, level6};
    String level = levels[currentLevel];
    
    
    
    public int getBoardHeight()
    {
        return this.h;
    }
    
    
    public int getBoardWidth() 
    {
        return this.w;
    }
    
   
    
    public void ShowLevelScreen(Graphics2D g2d) 
    {
        g2d.setBackground(Color.orange);
        
    	Font large = new Font("Calibri", Font.BOLD, 40);
    	Font medium = new Font("Calibri", Font.BOLD, 35);
    	Font small = new Font("Calibri", Font.BOLD, 25);
        Font extrasmall = new Font("Calibri", Font.PLAIN, 20);
    	
    	FontMetrics metr1 = this.getFontMetrics(large);
    	FontMetrics metr2 = this.getFontMetrics(medium);
        FontMetrics metr3 = this.getFontMetrics(small);
        
        String start ="press \"Enter\" to start and \"Q\" to quit";
        String dev = "Developed by Nikla Perera - 19s07047";
        
    	
    	if (currentLevel == 0)
        {
            String welcome = "Welcome to the Sokoban";
            String sokoban = "The game by Retro Games Ltd";
            String sLevel = "Level " + (currentLevel + 1);
            g2d.setFont(large);
	    g2d.drawString(welcome, (getBoardWidth() - metr1.stringWidth(welcome)) / 2, 100);
	    g2d.setFont(small);
	    g2d.drawString(sLevel, (getBoardWidth() - metr1.stringWidth(sLevel)) / 2, 200);
	    g2d.setFont(small);
	    g2d.drawString(start, (getBoardWidth() - metr3.stringWidth(start)) / 2, getBoardHeight() / 2 + 140 );
            g2d.setFont(extrasmall);
	    g2d.drawString(dev, (getBoardWidth() - metr3.stringWidth(start)) / 2 + 10, getBoardHeight() / 2 + 180 );
    	} 
        else
        {
            String fLevel = "Level: " + currentLevel;
            String  me = "Level Completed! to play next level...";
            g2d.setFont(large);
            g2d.drawString(fLevel, (getBoardWidth() - metr1.stringWidth(fLevel)) / 2, 160);
            g2d.setFont(medium);
            g2d.drawString(me, (getBoardWidth() - metr1.stringWidth(me)) / 2 + 20, 250);
            g2d.setFont(small);
	    g2d.drawString(start, (getBoardWidth() - metr3.stringWidth(start)) / 2, getBoardHeight() / 2 + 140 );
    	}
    }
    
    public Floor() 
    {
        addKeyListener(new TAdapter());
        
        timer = new Timer(1000, (ActionListener) this);
        timer.start();
        
        setFocusable(true);
        initMap();
    }
    
    public final void initMap()
    {
        int x = OFFSET;
        int y = OFFSET;
        
        wall Walle;
        box b;
        gem a;
        
        time = 0;
        
        for(int i = 0; i < level.length(); i++) 
        {
            char item = level.charAt(i);
            
            if(item == '\n')
            {
                y += SPACE;
                if(this.w < x) 
                {
                    this.w = x;
                }
                x = OFFSET;
            } 
            else if(item == '#')
            {
                Walle = new wall(x, y);
                Wall.add(Walle);
                x += SPACE;
            } 
            else if(item == '$')
            {
                b = new box(x, y);
                box.add(b);
                x += SPACE;
            } 
            else if (item == '.') 
            {
                a = new gem(x, y);
                gem.add(a);
                x += SPACE;
            }
            else if(item == '@') {
                player = new Man(x, y);
                x += SPACE;
            } 
            else if(item == ' ')
            {
                x += SPACE;
            }
            
            h = y;
        }
    }
    
    
    
    public void buildMap(Graphics g) 
    {   
        g.setColor(new Color(58, 61, 240));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        ArrayList<Actions> map = new ArrayList();
        map.addAll(Wall);
        map.addAll(gem);
        map.addAll(box);
        map.add(player);
        
        int levelDisplay = currentLevel + 1;
        
        for(int i = 0; i < map.size(); i++) 
        {
            Actions item = map.get(i);
            g.drawImage(item.getImage(), item.x(), item.y(), this);
            
            Font small = new Font("Calibri", Font.BOLD, 23);
            g.setFont(small);
            g.setColor(new Color(255, 255, 255));;
            
            
            g.drawString("Level  " + levelDisplay, 20, 24);
            
             g.drawString("Moves: " + player.moves, 580, 24);
            
            g.drawString("Time: " + time + "s", 1100, 24 );
            
            
           
            
            
        }
    }

    public void paint(Graphics g) 
    {
    	Graphics2D g2d = (Graphics2D) g;

    	super.paint(g2d);
        if(inGame) 
        {
            buildMap(g2d);
        }
        else 
        {
            ShowLevelScreen(g2d);
            restartLevel();
        }      
    }
    
    class TAdapter extends KeyAdapter 
    {
        public void keyPressed(KeyEvent e)
        {
            if (completed) 
            {
                return;
            }
            
            int key = e.getKeyCode();
            
            if (inGame) 
            {
            	if(key == KeyEvent.VK_LEFT) 
                {
                    if (checkWallCollision(player, LEFT_COLLISION))
                    {
                        return;
                    }
                    if (checkBoxCollision(LEFT_COLLISION))
                    {
                        return;
                    }
                    player.move(-SPACE, 0);
                } 
                else if(key == KeyEvent.VK_RIGHT)
                {
                    if (checkWallCollision(player, RIGHT_COLLISION))
                    {
                        return;
                    }
                    if (checkBoxCollision(RIGHT_COLLISION))
                    {
                        return;
                    }
                    player.move(SPACE, 0);
                } 
                else if(key == KeyEvent.VK_UP) 
                {
                    if (checkWallCollision(player, TOP_COLLISION)) 
                    {
                        return;
                    }
                    if (checkBoxCollision(TOP_COLLISION))
                    {
                        return;
                    }
                    player.move(0, -SPACE);
                } 
                else if (key == KeyEvent.VK_DOWN)
                {
                    if (checkWallCollision(player, BOTTOM_COLLISION))
                    {
                        return;
                    }
                    if (checkBoxCollision(BOTTOM_COLLISION)) 
                    {
                        return;
                    }
                    player.move(0, SPACE);
                } 
                else if (key == KeyEvent.VK_R)
                {
                    restartLevel();
                }
            }
            
            if (key == KeyEvent.VK_ENTER)
            {
                
                if(currentLevel == 5){
                    inGame = false;
                }
                else{
                    
                
                inGame = true;
                }
            }
            else if (key == KeyEvent.VK_Q) 
            {
            	System.exit(0);
            }
            repaint();
        }
    }
    
    

    private boolean checkBoxCollision(int type)
    {
        if(type == LEFT_COLLISION)
        {
            for(int i = 0; i < box.size(); i++) 
            {
                box b = box.get(i);
                if(player.isLeftCollision(b))
                {
                    for(int j=0; j < box.size(); j++) 
                    {
                        box item = box.get(j);
                        if(!b.equals(item)) 
                        {
                            if(b.isLeftCollision(item))
                            {
                                return true;
                            }
                        }
                        if(checkWallCollision(b, LEFT_COLLISION)) 
                        {
                            return true;
                        }
                    }
                    b.move(-SPACE, 0);
                    isCompleted();
                }
            }
            return false;
        } 
        else if(type == RIGHT_COLLISION)
        {
            for(int i = 0; i < box.size(); i++) 
            {
                box b = box.get(i);
                if(player.isRightCollision(b)) 
                {
                    for(int j=0; j < box.size(); j++)
                    {
                        box item = box.get(j);
                        if(!b.equals(item))
                        {
                            if (b.isRightCollision(item))
                            {
                                return true;
                            }
                        }
                        if(checkWallCollision(b, RIGHT_COLLISION)) 
                        {
                            return true;
                        }
                    }
                    b.move(SPACE, 0);
                    isCompleted();                   
                }
            }
            return false;
        }
        else if(type == TOP_COLLISION)
        {
            for(int i = 0; i < box.size(); i++) 
            {
                box b = box.get(i);
                if(player.isTopCollision(b))
                {
                    for(int j = 0; j < box.size(); j++)
                    {
                        box item = box.get(j);
                        if(!b.equals(item)) 
                        {
                            if(b.isTopCollision(item)) 
                            {
                                return true;
                            }
                        }
                        if(checkWallCollision(b, TOP_COLLISION))
                        {
                            return true;
                        }
                    }
                    b.move(0, -SPACE);
                    isCompleted();
                }
            }
            return false;
        } 
        else if(type == BOTTOM_COLLISION)
        {
            for(int i = 0; i < box.size(); i++) 
            {
                box b = box.get(i);
                if(player.isBottomCollision(b)) 
                {
                    for(int j = 0; j < box.size(); j++) 
                    {
                        box item = box.get(j);
                        if(!b.equals(item)) 
                        {
                            if (b.isBottomCollision(item)) 
                            {
                                return true;
                            }
                        }
                        if(checkWallCollision(b, BOTTOM_COLLISION))
                        {
                            return true;
                        }
                    }
                    b.move(0, SPACE);
                    isCompleted();
                }
            }
        }
        return false;
    }
    private boolean checkWallCollision(Actions actor, int type)
    {
        if(type == LEFT_COLLISION)
        {
            for(int i = 0; i < Wall.size(); i++) 
            {
                 wall Walle = Wall.get(i);
                if(actor.isLeftCollision(Walle)) 
                {
                    return true;
                }
            }
            return false;
        } 
        else if(type == RIGHT_COLLISION)
        {
            for (int i = 0; i < Wall.size(); i++)
            {
                 wall Walle = Wall.get(i);
                if (actor.isRightCollision(Walle))
                {
                    return true;
                }
            }
            return false;
        } 
        else if(type == TOP_COLLISION)
        {
            for (int i = 0; i < Wall.size(); i++) 
            {
                wall Walle = Wall.get(i);
                if (actor.isTopCollision(Walle))
                {
                    return true;
                }
            }
            return false;
        } 
        else if(type == BOTTOM_COLLISION)
        {
            for(int i = 0; i < Wall.size(); i++)
            {
                wall Walle = Wall.get(i);
                if (actor.isBottomCollision(Walle))
                {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(inGame)
        {
            time++;
	}
        
        repaint();
    }
    
    public void isCompleted() 
    {
        int num = box.size();
        int boxCompleted = 0;
        
        for(int i = 0; i < num; i++)
        {
            box b = box.get(i);
            for(int j = 0; j < num; j++)
            {
               gem box = gem.get(j);
                if(b.x() == box.x() && b.y() == box.y()) 
                {
                    boxCompleted += 1;
                }
            }
        }
        
        
        if(boxCompleted == num)
        {
            completed = true;
            repaint();
            
            EventQueue.invokeLater(() ->
            {
                    try{
                        Thread.sleep(500);
                    }
                    catch(InterruptedException ex){
                        
                    }
                    
                    restartLevel();
            });
            
            try
            {

            if(currentLevel < 5)
            {
            	currentLevel++;
                level = levels[currentLevel];	
            }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"you have finished all the levels successfully ! "," Execellent, Well done !",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
    
    
    
    public void restartLevel() 
    {
        repaint();
        
        gem.clear();
        box.clear();
        Wall.clear();
        
        initMap();
        
        inGame = false;
        
        if(completed) 
        {
            completed = false;
        }
    }
    
    
}

