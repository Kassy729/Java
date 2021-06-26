package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

   private JPanel panel;
   private JTextField display;
   private JButton[] buttons;
   private String[] labels = { "Backspace", "", "", "CE", "C", "7", "8", "9",
         "/", "sqrt", "4", "5", "6", "x", "%", "1", "2", "3", "-", "1/x",
         "0", "-/+", ".", "+", "=", };  
   
   private double result = 0;  
   private String operator = "=";
   private boolean startOfNumber = true;

   public Calculator() {
      display = new JTextField(35);  //버튼을 눌렀을때 계산화면을 보여주는 텍스트필드 생성
      panel = new JPanel();
      display.setText("0.0");  //처음 화면에 0.0으로 지정
      display.setEnabled(true);  //계산화면은 수정하지 못하도록 설정

      panel.setLayout(new GridLayout(0, 5, 3, 3));
      buttons = new JButton[25];  //숫자와 계산기호를 담기위한 버튼 생성
      int index = 0;
      for (int rows = 0; rows < 5; rows++) {  
         for (int cols = 0; cols < 5; cols++) {
        	 //반복문 하나만 사용해도 되지만 숫자부분이랑 계산하는 부분의 색깔을 다르게 지정해줘야하기 때문에 반복문을 2개 사용
            buttons[index] = new JButton(labels[index]);
            if (cols >= 3)
               buttons[index].setForeground(Color.red);  //수식부분의 버튼은 빨간색으로 지정
            else
               buttons[index].setForeground(Color.blue);  //숫자버튼부분은 파란색으로 지정
            buttons[index].setBackground(Color.yellow);  
            panel.add(buttons[index]);
            buttons[index].addActionListener(this);
            index++;
         }
      }
      add(display, BorderLayout.NORTH);  //계산화면은 북쪽에 위치
      add(panel, BorderLayout.CENTER);  //계산버튼 부분은 센터에 위치
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);  //화면이 가운데 나오도록 설정  
      setResizable(false);  //화면을 늘리고 줄이고 못하도록 설정
      setVisible(true);  //화면이 나오도록 설정
      pack();  //사이즈를 크기에 맞게 자동으로 설정
   }

   public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();  
      if (command.charAt(0) == 'C') {  //커멘드를 받아와서 값이 C이면 리셋시키는 이벤트를 추가
         startOfNumber = true;
         result = 0;
         operator = "=";
         display.setText("0.0");
      } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9'|| command.equals(".")) {
    	  //0 ~ 9사이의 값이나 "." 값이 오면 그 값을 디스플레이에 출력한다.
    	  	if (startOfNumber == true)
    	  		display.setText(command);
    	  	else
    	  		display.setText(display.getText() + command);
         startOfNumber = false;  //0 ~ 9 또는 "."이 아니라면 false를 반환하여 값을 입력안되도록 설정
      } else {
         if (startOfNumber) {  
            if (command.equals("-")) {  //연산기호중에 "-"는 처음에 입력이 가능하도록 설정
               display.setText(command);  
               startOfNumber = false;
            } else
               operator = command;
         } else {
            double x = Double.parseDouble(display.getText());  
            calculate(x);  //calculate메소드에 넣는다.
            operator = command;
            startOfNumber = true;
         }
      }
   }

   private void calculate(double n) {
      if (operator.equals("+"))  
         result += n;
      else if (operator.equals("-"))
         result -= n;
      else if (operator.equals("x"))
         result *= n;
      else if (operator.equals("/"))
         result /= n;
      else if (operator.equals("="))
         result = n;
      display.setText("" + result);
   }

   public static void main(String args[]) {
      Calculator s = new Calculator();
   }
}