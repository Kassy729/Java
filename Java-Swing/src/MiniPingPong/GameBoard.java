package MiniPingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements KeyListener{
    Ball ball;  
    Racket racket1;
    Racket racket2;
    static PointLabel point;  //점수 판

    public GameBoard()
    {
        ball=new Ball(this,Color.red);  //볼의 색깔을 선택한다.
        this.setBackground(Color.green);  //테이블 색깔을 선택한다.
        racket1=new Racket(this,10,150,Color.blue,1); //라켓의 위치와 색, int값 1을 준다.(1번라켓임을 나타내기위함)
        racket2=new Racket(this, 580, 150, Color.yellow,2);
        //라켓의 위치와 색, int값 2를 준다.(2번라켓임을 나타내기위함)
        this.setFocusable(true);  //키를 눌렀을경우 가장 먼저 
        this.addKeyListener(this);  //키 이벤트를 추가한다.
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {  //라켓에 keyPressed 이벤트를 준다.
        racket1.keyPressed(e);
        racket2.keyPressed(e);        
    }

    @Override
    public void keyReleased(KeyEvent e) {  //라켓에 손을 땠을때 움직이지 않도록 하기 위해 이벤트를 준다.
        // TODO Auto-generated method stub
        racket1.keyReleased(e);
        racket2.keyReleased(e);
    }

    private void move()  //움직임 메소드 
    {
        ball.move();
        racket1.move();
        racket2.move();
        point.setPoint(ball.getPoint1(),ball.getPoint2());  // 점수 라벨에 점수 대입
        point.setPointPanel();  // 위에 점수로 점수표 바꾸기
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d= (Graphics2D) g;  //볼과 라켓을 다루기 위해 형변환 한다.
        ball.draw(g2d);  //볼을 그려주는 메소드 호출
        racket1.draw(g2d);  //라켓1번을 그려주는 메소드 호출
        racket2.draw(g2d);  //라켓2번을 그려주는 메소드 호출
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Mini_Ping_Pong_Game");
        frame.setSize(600,400);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameBoard game=new GameBoard();
        point=new PointLabel();
        game.add(point, BorderLayout.NORTH);    
        frame.add(game);
        
        frame.setVisible(true);
        while(true)
        {
            game.move();
            game.revalidate();  
            game.repaint();
            try{
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
    }
}
