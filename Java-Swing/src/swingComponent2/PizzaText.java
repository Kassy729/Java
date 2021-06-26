package swingComponent2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//설명
//temp1,2,3 각각의 값을 저장한다음 마지막에 더한값을 출력함
//피자 종류별 가격은 temp1에 저장하고 토핑추가 가격은 temp2에 저장하고 사이즈 가격은 temp3에 저장한다

class Pizza extends JFrame implements ActionListener{
   private int sum, temp1, temp2, temp3;
   private JButton order_button, cancle_button;
   private JPanel down_panel;
   private JTextField text;
   private ActionEvent z;
   
   WelcomPanel welcom_panel = new WelcomPanel();
   TypePanel type_Panel = new TypePanel();
   ToppingPanel ToppingPanel = new ToppingPanel();
   SizePanel size_Panel = new SizePanel();
   
   public Pizza() {
      this.setSize(500,200);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("피자 주문");
      
      this.order_button = new JButton("주문");
      this.order_button.addActionListener(this);
      this.cancle_button = new JButton("취소");
      this.cancle_button.addActionListener(this);
      
      this.text = new JTextField();
      text.setEditable(false);
      text.setColumns(6);
      
      down_panel = new JPanel();
      down_panel.add(this.order_button);
      down_panel.add(this.cancle_button);
      down_panel.add(this.text);
      
      this.setLayout(new BorderLayout());
      
      this.add(welcom_panel, BorderLayout.NORTH);
      this.add(down_panel, BorderLayout.SOUTH);
      this.add(size_Panel, BorderLayout.EAST);
      this.add(type_Panel, BorderLayout.WEST);
      this.add(ToppingPanel, BorderLayout.CENTER);
      
      this.setVisible(true);
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      sum = temp1 + temp2 + temp3;
      if(e.getSource() == this.order_button)
         this.text.setText(" " + sum);
      if(e.getSource() == this.cancle_button) {
         temp1 = 0;
         temp2 = 0;
         temp3 = 0;
         sum = 0;
         this.text.setText(" " + sum);
      }
      
   }
   
   class WelcomPanel extends JPanel{
      private JLabel message;
      
      public WelcomPanel() {
         message = new JLabel("자바 피자에 오신것을 환영합니다.");
         add(message);
      }
   }
   
   class TypePanel extends JPanel implements ActionListener{
      private JRadioButton combo, potato, bulgogi;
      private ButtonGroup bg;
      
      public TypePanel() {
         setLayout(new GridLayout(3,1));
         combo = new JRadioButton("콤보", true);
         potato = new JRadioButton("포테이토");
         bulgogi = new JRadioButton("불고기");
         
         bg = new ButtonGroup();
         bg.add(combo);
         bg.add(potato);
         bg.add(bulgogi);
         
         setBorder(BorderFactory.createTitledBorder("종류"));
         
         add(combo);
         add(potato);
         add(bulgogi);
         
         combo.addActionListener(this);
         potato.addActionListener(this);
         bulgogi.addActionListener(this);
         
         setBorder(BorderFactory.createTitledBorder("종류"));
         
         add(combo);
         add(potato);
         add(bulgogi);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == combo)
            temp1 = 5000;
         else if(e.getSource() == potato)
            temp1 = 7000;
         else 
            temp1 = 10000;
      }

      
   }
   
   class ToppingPanel extends JPanel implements ActionListener{
      private JRadioButton pepper, cheese, peperoni, bacon;
      private ButtonGroup bg;
      
      public ToppingPanel() {
         setLayout(new GridLayout(4,1));
         
         pepper = new JRadioButton("피망", true);
         cheese = new JRadioButton("치즈");
         peperoni = new JRadioButton("페페로니");
         bacon = new JRadioButton("베이컨");
         
         bg = new ButtonGroup();
         bg.add(pepper);
         bg.add(cheese);
         bg.add(peperoni);
         bg.add(bacon);
         
         pepper.addActionListener(this);
         cheese.addActionListener(this);
         peperoni.addActionListener(this);
         bacon.addActionListener(this);
         
         setBorder(BorderFactory.createTitledBorder("추가토핑"));
         
         add(pepper);
         add(cheese);
         add(peperoni);
         add(bacon);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == pepper)
            temp2 = 500;
         else if(e.getSource() == cheese)
            temp2 = 1000;
         else if(e.getSource() == peperoni)
            temp2 = 1500;
         else {
            temp2 = 2000;
         }
      }

   }
   
   class SizePanel extends JPanel implements ActionListener{
      private JRadioButton small, medium, large;
      private ButtonGroup bg;
      
      public SizePanel() {
         setLayout(new GridLayout(3,1));
         
         small = new JRadioButton("small", true);
         medium = new JRadioButton("medium");
         large = new JRadioButton("large");
         
         bg = new ButtonGroup();
         bg.add(small);
         bg.add(medium);
         bg.add(large);
         
         small.addActionListener(this);
         medium.addActionListener(this);
         large.addActionListener(this);
         
         setBorder(BorderFactory.createTitledBorder("크기"));
         
         add(small);
         add(medium);
         add(large);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == small)
            temp3 = 10000;
         else if(e.getSource() == medium)
            temp3 = 15000;
         else {
            temp3 = 20000;
         }
      }

   }
   
}

public class PizzaText{
   public static void main(String[] args) {
      Pizza pizza = new Pizza();
   }
}