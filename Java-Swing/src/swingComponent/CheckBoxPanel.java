package swingComponent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;
import java.util.Iterator;

public class CheckBoxPanel extends JPanel implements ItemListener{
	private JCheckBox button[] = new JCheckBox[3];
	private ImageIcon icon[] = new ImageIcon[3];
	private JLabel Label[] = new JLabel[3];
	private String fruit[] = {"apple", "grape", "orange"};
	
	public CheckBoxPanel() {
		
		super(new GridLayout(0,4));
		for (int i = 0; i < Label.length; i++) {
			button[i] = new JCheckBox(fruit[i]);
			icon[i] = new ImageIcon(fruit[i] + ".gif");
			Label[i] = new JLabel(fruit[i] + ".gif");
			button[i].addItemListener(this);
			
		}
		
		JPanel panel = new JPanel(new GridLayout(0,1));
		for (int j = 0; j < Label.length; j++) {
			panel.add(button[j]);
		}
		
		add(panel);
		add(Label[0]);
		add(Label[1]);
		add(Label[2]);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		ImageIcon imageIcon = null;
		Object source = e.getItemSelectable();
		for(int i=0; i<3; i++) {
			if(source == button[i]) {
				if(e.getStateChange() == ItemEvent.DESELECTED)
					Label[i].setIcon(null);
				else {
					Label[i].setIcon(icon[i]);
				}
			}
				
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Chelc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckBoxPanel panel = new CheckBoxPanel();
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
	
}