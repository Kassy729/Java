package swing;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tic_Tac_Toe extends JPanel implements ActionListener {
   JButton[][]buttons = new JButton[3][3];  //2차원 배열을 통해 격자모양으로 버튼을 생성
   private char turn = 'X';

   public Tic_Tac_Toe() {
      setLayout(new GridLayout(3, 0, 5, 5));  //가로로 3개씩만 배치하고 밑으로 배치 하고 간격은 5로 지정
      Font f = new Font("Dialog", Font.ITALIC, 50);

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            buttons[i][j] = new JButton(" ");  
            buttons[i][j].setFont(f);  //각각의 버튼에 폰트를 지정
            buttons[i][j].addActionListener(this);  //각각의 버튼에 이벤트를 추가
            add(buttons[i][j]);  //버튼을 패널에 추가함
         }
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (e.getSource() == buttons[i][j]  //버튼의 값을 e.getSource를 통해서 받아옴
                  && buttons[i][j].getText().equals(" ") == true) {
               if (turn == 'X') {
                  buttons[i][j].setText("X");
                  turn = 'O';
                  if (checkWin("X", i, j))
                     System.out.println("X가 이겼습니다!!");
                  else if (isDraw()) //isDraw메소드를 호출해서 비겼는지 검사
                     System.out.println("비겼어요.");
               } else {
                  buttons[i][j].setText("O");
                  turn = 'X';
                  if (checkWin("O", i, j))  //checkWin메소드를 사용해서 승자를 구함
                     System.out.println("O가 이겼습니다");
                  else if (isDraw()) 
                     System.out.println("비겼어요.");
               }
            }
         }
      }
   }

   public boolean isDraw() {  //게임을 비겼는지 검사한다.
      for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
            if (buttons[row][col].getText().equals(" ")) {
               return false;
            }
         }
      }
      return true;
   }

   public boolean checkWin(String mark, int r, int c) {
      return (buttons[r][0].getText().equals(mark) && buttons[r][1].getText().equals(mark)
            && buttons[r][2].getText().equals(mark)|| buttons[0][c].getText().equals(mark)
            && buttons[1][c].getText().equals(mark) && buttons[2][c].getText().equals(mark) || buttons[0][0].getText().equals(mark)
            && buttons[1][1].getText().equals(mark) && buttons[2][2].getText().equals(mark) ||  buttons[0][2].getText().equals(mark)
            && buttons[1][1].getText().equals(mark) && buttons[2][0].getText().equals(mark));
   }// 한줄에 같은 문자 3개가 되었는지 검사한다.

   public static void main(String[] args) {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Tic_Tac_Toe());
      f.setSize(300, 300);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
}