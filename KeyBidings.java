import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBidings extends JFrame {
    int x = 0;
    int y = 0;
    
    int x1=100;
    
    int y1 =100;
    
    DrawPanel drawPanel = new DrawPanel();
    
    public KeyBidings(){
        Action rightAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if((x+50)<200)
                {
                x +=10;
                drawPanel.repaint();
                }

            }
        };
        Action leftAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
            if(x!=0)
            {
               x -=10;
                drawPanel.repaint();
            }
            }
        };
        
        Action upAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if(y!=0)
                {
               y-=10;
                drawPanel.repaint();
                }
            }
        };
        Action downAction = new AbstractAction(){
        
            public void actionPerformed(ActionEvent e) {
                if((y+50)<200)
                {
               y +=10;
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
       // setSize(200,200);
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
        }

        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
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
