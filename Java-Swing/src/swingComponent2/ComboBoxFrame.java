package swingComponent2;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;

public class ComboBoxFrame extends JFrame implements ActionListener{
	JLabel label;
	
	public ComboBoxFrame() {
		setTitle("콤보박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		
		String[]Fruits = {"apple", "grape", "orange"};
		JComboBox animalList = new JComboBox(Fruits);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(Fruits[animalList.getSelectedIndex()]);
		add(animalList, BorderLayout.PAGE_START);
		add(label, BorderLayout.PAGE_END);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cd = (JComboBox)e.getSource();
		String name = (String)cd.getSelectedItem();
		changePicture(name);
	}
	
	public void changePicture(String name) {
		ImageIcon icon = new ImageIcon(name + ".gif");
		label.setIcon(icon);
		if(icon != null) {
			label.setText(null);
		}else {
			label.setText("이미지가 없습니다!!");
		}
	}
	public static void main(String[] args) {
		ComboBoxFrame frame = new ComboBoxFrame();
	}
}