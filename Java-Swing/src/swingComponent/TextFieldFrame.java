package swingComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame implements ActionListener{
	private JButton button;
	private JTextField input, result;
	private JPanel panel;
	
	public TextFieldFrame() {
		setSize(300,130);
		setTitle("제곱 계산하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.add(new JLabel("숫자입력 : "));
		input = new JTextField(15);
		input.addActionListener(this);
		panel.add(input);
		
		panel.add(new JLabel("제곱한 값 : "));
		result = new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		button = new JButton("OK");
		panel.add(button);
		button.addActionListener(this);
		add(panel);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button || e.getSource() == input) {
			String name = input.getText();
			int value = Integer.parseInt(name);
			result.setText("" + value * value);
			input.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new TextFieldFrame();
	}
}
