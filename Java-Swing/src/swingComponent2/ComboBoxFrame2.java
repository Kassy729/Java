package swingComponent2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame2 extends JFrame implements ActionListener {
	JLabel label;

	public ComboBoxFrame2() {
		setTitle("콤보 박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		String[] fruits = { "apple", "grape", "orange" };
		JComboBox<String> animalList = new JComboBox<>(fruits);

		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		animalList.setEditable(true);
		animalList.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String item = animalList.getEditor().getItem().toString();
					boolean canAdd = true;
					for (int i = 0; i < animalList.getItemCount(); i++) {
						if (animalList.getItemAt(i).toString().equals(item)) {
							canAdd = false;
							break;
						}
					}
					if (canAdd) {
						animalList.addItem(item);
						animalList.setSelectedItem(item);
					}
				}
			}

		});

		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(fruits[animalList.getSelectedIndex()]);
		
		add(animalList, BorderLayout.PAGE_START);
		add(label, BorderLayout.PAGE_END);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		String name = (String) cb.getSelectedItem();
		changePicture(name);
	}
	
	private void changePicture(String name) {
		File file = new File(name + ".gif");
		ImageIcon icon = new ImageIcon(file.getPath());
		this.label.setIcon(icon);
		
		if (file.isFile()) {
			this.label.setText(null);
		} else {
			this.label.setText("이미지를 찾을 수 없습니다");
		}
		
	}

	public static void main(String[] args) {
		ComboBoxFrame2 frame = new ComboBoxFrame2();
	}
}

