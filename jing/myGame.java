package com.jing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class myGame extends JFrame
{
    MyPanel mp = null;


    public static void main(String[] args)
    {
        myGame mg = new myGame();
    }
    public myGame()
    {
        mp = new MyPanel();
        this.add(mp);
        //监听
        this.addKeyListener(mp);
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
class MyPanel extends JPanel implements KeyListener
{
    int x = 10,y =10;
    //画笔
    public void paint(Graphics g)
    {

        super.paint(g);
        //g.drawOval(x,y,30,30);
        Graphics2D g2d=(Graphics2D)g;
        if(true)
        {
            Color color=new Color(0xFF0000);
            g2d.setPaint(color);
            g2d.fillOval(x,y,30,30);
        }

    }
    public void keyPressed(KeyEvent arg0)
    {
        if(arg0.getKeyCode()==KeyEvent.VK_UP)
        {
            y-=10;
        }
        if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
        {
            y+=10;
        }
        if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            x+=10;
        }
        if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
        {
            x-=10;
        }
        this.repaint();
    }
    public void keyReleased(KeyEvent arg0)
    {

    }
    public void keyTyped(KeyEvent arg0)
    {

    }
}
