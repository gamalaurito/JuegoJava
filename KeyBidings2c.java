import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBidings2c extends JFrame {
    private int tamx = 1200;
    private int tamy = 700; 
    int x = 0;
    int y = 0;
    int x1=100;
    int y1 =100;

    int yc1 = tamy;
    int xc1 = tamx;
    int xc = xc1 - 50;
    int yc = yc1 - 50;
    
    DrawPanel drawPanel = new DrawPanel();
    
    public KeyBidings(){
        Action rightAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if((x+50)<tamx)
                {
                x +=10;
                xc -=10;
                drawPanel.repaint();
                }

            }
        };
        Action leftAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
            if(x!=0)
            {
               x -= 10;
               xc += 10;
                drawPanel.repaint();
            }
            }
        };
        
        Action upAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if(y!=0)
                {
               y-=10;
               yc +=10;
                drawPanel.repaint();
                }
            }
        };
        Action downAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if((y+50)<tamy)
                {
               y +=10;
               yc -= 10;
                drawPanel.repaint();
                }
            }
        };

       	InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
       	ActionMap actionMap = drawPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        actionMap.put("rightAction", rightAction);
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        actionMap.put("leftAction", leftAction);
        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        actionMap.put("upAction", upAction);
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("downAction", downAction);
        add(drawPanel);
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       	setSize(tamx, tamy);
	setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.BLACK);
            g.fillRect(x+5,y+5,40,40);
            g.setColor(Color.GREEN);
            g.fillRect(xc, yc, 50, 50);
            g.setColor(Color.BLACK);
            g.fillRect(xc + 5, yc + 5, 40, 40);


        }

        public Dimension getPreferredSize() {
            return new Dimension(tamx, tamy);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new KeyBidings();
            }
        });
    }
}

