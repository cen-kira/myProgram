package com.jing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    class TestPane extends JPanel
    {
        int x,y;
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
        public void paint(Graphics g,Graphics2D g2d)
        {
            super.paint(g);
            super.paint(g2d);
            g.setColor(Color.RED);
            g.fillOval(x,y,30,30);
    }

    }
}