package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.Timer;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class AnimationTest extends JPanel implements ActionListener{
   
   private final int WIDTH = 500;
   private final int HEIGHT = 300;
   private final int START_X = 0;
   private final int START_Y = 0;
   private int dx, dy;
   private BufferedImage Image;
   private Timer timer;
   private int x, y;
   
   public AnimationTest() {
      setBackground(Color.BLACK);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setDoubleBuffered(true);
      
      File input = new File("ship.jpg");
      try {
         Image = ImageIO.read(input);
      } catch (Exception e) {
         e.printStackTrace();
      }
      x = START_X;
      y = START_Y;
      dx = 1;
      dy = -1;
      
      timer = new Timer(1, this);
      timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(Image, x, y, this);
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(dx > 0) 
         x++;
      else 
         x--;
      
      if(dy>0) 
         y++;
      else 
         y--;
      
      if(x + 100 > WIDTH || x <0) {
         dx = -dx;
      }
      
      if(y + 110 >HEIGHT || y <0) {
         dy = -dy;
      }
      repaint();
   }

}

public class AnimationBasic extends JFrame{
   public AnimationBasic() {
      add(new AnimationTest());
      setTitle("애니메이션 테스트");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500,300);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
   }
   
   public static void main(String[] args) {
      new AnimationBasic();
   }
}