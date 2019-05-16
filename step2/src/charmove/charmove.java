//★ AWT 矢印キーでキャラクタを動かす    前田 稔
//   appletviewer charmove.htm
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class charmove extends Applet implements KeyListener
{   static  Image   img;
    int     x= 50, y= 50, dir= 0, num= 0;

    public void init()
    {   setBackground(Color.gray);
        img = getImage(getDocumentBase(),"chr47.gif");
        addKeyListener(this);
    }

    public void paint(Graphics g)
    {   int yoff;
        Dimension  size = getSize();
        g.setColor(getBackground());
        g.fillRect(0, 0, size.width, size.height);
        if (img!=null)
        {
		    yoff= (dir*2+num)*32;
            g.drawImage(img,x,y,x+32,y+32,0,yoff,32,yoff+32,this);
        }
    }

    // KeyEvent Listener
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {   case KeyEvent.VK_UP : y=y-10; dir=0; break;
            case KeyEvent.VK_RIGHT : x=x+10; dir=1; break;
            case KeyEvent.VK_DOWN : y=y+10; dir=2; break;
            case KeyEvent.VK_LEFT : x=x-10; dir=3; break;
        }
        num ^= 1;
        repaint();
    }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }
}