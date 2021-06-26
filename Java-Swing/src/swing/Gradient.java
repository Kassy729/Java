package swing;

import java.awt.BasicStroke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D.Float;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gradient extends JFrame{
	public Gradient() {
		setSize(600,130);
		setTitle("Java 2D Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Gradient();
	}
}

class MyPanel extends JPanel{
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
							RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setStroke(new BasicStroke(3));
		GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70, Color.RED);
		
		//사각
		g2.setPaint(Color.RED);
		g2.fill(new Rectangle2D.Float(10, 10, 70, 80));
		
		//둥근사각형
		g2.setPaint(gp);
		g2.fill(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
		
		//원
		g2.setPaint(Color.red);
		g2.fill(new Ellipse2D.Float(210, 10, 80, 80));
		
		//그라데이션 반달
		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(310, 10, 80, 80, 45, 220, Arc2D.OPEN));
		
		//반달
		g2.setPaint(Color.red);
		g2.fill(new Arc2D.Float(410, 10, 80, 80, 45, 220, Arc2D.OPEN));
		
		//팩
		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(510, 10, 80, 80, 45, 225, Arc2D.PIE));
				
	}
}
