package swingComponent2;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Capture2 extends JFrame implements ActionListener {
	private Robot robot;
	private JPanel CapturePanel;
	private JTextField width_text, height_text, setX_text, setY_text;
	//캡처 하고 싶은 부분의 크기나 위치등을 주기 위해 필드를 생
	private JButton button;
	//버튼을 누르면 캡처
	private int width, height, setX, setY;
	//캡처할 위치와 크기

	public Capture2() {
//		super("화면 캡쳐");

		CapturePanel = new JPanel();
		CapturePanel.setLayout(new GridLayout(3, 1));

		CapturePanel.add(new JLabel("사이즈 입력 : |가로| |세로|"));
		width_text = new JTextField(15); // 가로길이 
		height_text = new JTextField(15); // 세로길 
		CapturePanel.add(width_text);
		CapturePanel.add(height_text);

		CapturePanel.add(new JLabel("위치 입력 : |x| |y|"));
		setX_text = new JTextField(15); // x좌표 위치 선택
		setY_text = new JTextField(15); // y좌표 위치 선택
		CapturePanel.add(setX_text);
		CapturePanel.add(setY_text);

		
		CapturePanel.add(new JLabel());
		button = new JButton("화면 캡쳐"); 
		button.addActionListener(this); // 버튼을 누르면 화면캡처 이벤트발생
		CapturePanel.add(button);
		this.add(CapturePanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			robot = new Robot(); 
			setX = Integer.parseInt(setX_text.getText());
			setY = Integer.parseInt(setY_text.getText());
			width = Integer.parseInt(width_text.getText());
			height = Integer.parseInt(height_text.getText());
			// getText로 받은 텍스트를 Integer로 변환
			
			Rectangle area = new Rectangle(setX, setY, width, height);
			BufferedImage bufferedImage = robot.createScreenCapture(area);
			ImageIO.write(bufferedImage, "jpg", new File("./화면캡쳐.jpg"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Capture2();
	}
}