
/**
 * Write a description of class Graphics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
public class Graphiks extends JPanel
{
    int count=0;
    public void nextCount()
    {
        count++;
    }

    public void resetCount()
    {
        count=0;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; 

        g2.setStroke(new BasicStroke(5,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.BLACK); 
        g.drawLine(50, 30, 50, 10);
        g.drawLine(50, 10, 130, 10);
        g.drawLine(130, 10, 130, 300);
        g.drawLine(20, 300, 150, 300);

        if (count>=1)
        {
            //draws the head
            g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            Ellipse2D.Double head = new Ellipse2D.Double(25, 30, 50, 50);
            g2.draw(head); 
        }

        if (count>=2)
        {
            //draws the body
            g.drawLine(50, 80, 50, 180);
        }
        if (count>=3)
        {
            //draws the left arm
            g.drawLine(10, 150, 50, 100);
        }
        if (count>=4)
        {
            //draws the right arm
            g.drawLine(50, 100, 90, 150);
        }
        if (count>=5)
        {
            //draws the left leg
            g.drawLine(30, 250, 50, 180);
        }
        if (count>=6)
        {
            //draws the right leg
            g.drawLine(50, 180, 70, 250);
        }
        if (count>=7)
        {
            //draws the left eye
            Ellipse2D.Double lefteye = new Ellipse2D.Double(40, 50, 1, 1);
            g2.draw(lefteye); 
            g2.fill(lefteye);
        }
        if (count>=8)
        {
            //draws the right eye
            Ellipse2D.Double righteye = new Ellipse2D.Double(58, 50, 1, 1);
            g2.draw(righteye); 
            g2.fill(righteye);
        }
        if (count>=9)
        {
            //draws the mouth
            Arc2D.Double mouth = new Arc2D.Double(40.00, 50.00, 20.00, 20.00, 180.00, 190.00, Arc2D.OPEN); 
            g2.draw(mouth); 
        }
    }
}
