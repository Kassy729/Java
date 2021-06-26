package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelTest extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public ImageLabelTest() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		label = new JLabel("이미지를 보려면 버튼을 누르세요");
		
		button = new JButton();
		ImageIcon icon = new ImageIcon("jpg");
		button.setIcon(icon);
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon dog = new ImageIcon("dogg.gif");
		File file = new File("ship.jpg");
		System.out.print(dog);
		label.setIcon(dog);
		label.setText(null);
	}
	
	public static void main(String[] args) {
		new ImageLabelTest();
	}
}
