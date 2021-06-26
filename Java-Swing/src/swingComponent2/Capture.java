package swingComponent2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

class CapturTest extends JFrame implements ActionListener{
	private JButton button;
	private Robot robot;
	private JPanel panel;
	
	public CapturTest() {
		panel = new JPanel();
		button = new JButton("캡쳐");
		button.addActionListener(this);
		panel.add(button);
		this.add(panel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        try {
            robot = new Robot();
            Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(area);
            ImageIO.write(bufferedImage, "jpg", new File("./src/swingComponent2/화면캡쳐.jpg"));
        } catch (AWTException AWTe) {
            AWTe.printStackTrace();
        } catch (IOException ioE) {
            ioE.printStackTrace();
        }

    }
}

public class Capture{
	public static void main(String[] args) {
		new CapturTest();
	}
}