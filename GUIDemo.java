import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton teleportButton;

    /**
     * Set up the application.
     */
    public GUIDemo()
    {
        setTitle("Bigger/Smaller/Teleport");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        teleportButton = new JButton("TELEPORT");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        teleportButton.addActionListener(new ButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(teleportButton);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Random ran = new Random();
            int x;
            int y;
            
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            else if (e.getSource().equals(smallerButton))
            {
                setSize(size.width - 10, size.height - 10);
            }
            else if (e.getSource().equals(teleportButton))
            {
                x = ran.nextInt(300);
                y = ran.nextInt(300);
                setLocation(x, y);
            }

        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
