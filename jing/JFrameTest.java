package com.jing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JFrameTest extends JFrame
{
    TestPane tp = null;

    public static void main(String[] args)
    {
        new JFrameTest();

    }
    public JFrameTest()
    {

        tp = new TestPane();
        this.add(tp);
        this.addKeyListener(tp);
        this.setSize(300,400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    class TestPane extends JPanel implements KeyListener
    {
        int x,y;
        int x1 = 50;
        int y1 = 50;
        int m=1;
        int n=1;
        public TestPane()
        {
            Timer timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x+=m;
                    if((x+30)>getWidth())
                    {
                        x = getWidth() - 30;
                        m *= -1;
                    } else if(x<0)
                    {
                        x=0;
                        m *= -1;
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(200,200);
        }

        @Override
        public void paint(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            super.paint(g);
            super.paint(g2d);
            g.setColor(Color.RED);
            g.fillOval(x,y,30,30);
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x1,y1,30,30);

    }
        public void keyPressed(KeyEvent arg0)
        {
            if(arg0.getKeyCode()==KeyEvent.VK_UP)
            {
                y1-=20;
            }
            if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
            {
                y1+=20;
            }
            if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
            {
                x1-=20;
            }
            if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                x1+=20;
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
}