package swingComponent;

import java.awt.BorderLayout;
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonFrame extends JFrame implements ActionListener{
	private JRadioButton small, medium, large;
	private JLabel text;
	private JPanel topPanel, centerPanel, resultPanel;
	
	public RadioButtonFrame() {
		setTitle("라디오 버튼");
		setSize(500,200);
//		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel();
		label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		topPanel = new JPanel();
		topPanel.add(label);
		add(topPanel, BorderLayout.NORTH);
		
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");
		centerPanel = new JPanel();
		centerPanel.add(small);
		centerPanel.add(medium);
		centerPanel.add(large);
		add(centerPanel, BorderLayout.CENTER);
		
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);
		
		resultPanel = new JPanel();
		text = new JLabel("크기가 선택되지 않았습니다");
		text.setForeground(Color.red);
		resultPanel.add(text);
		add(resultPanel, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == small)
			text.setText("Small 크기가 선택되었습니다.");
		if(e.getSource() == medium)
			text.setText("medium 크기가 선택되었습니다");
		if(e.getSource() == large)
			text.setText("large 크기가 선택되었습니다");
	}
	public static void main(String[] args) {
		new RadioButtonFrame();
	}
	
}
