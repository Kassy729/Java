package MiniPingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Racket {
    private static final int WIDTH=10;  //라켓의 가로 길이를 지정
    private static final int HEIGHT=80;  //라켓의 세로 길이를 지정
    int x=0;  //라켓의 x위치
    int y=0;  //라켓의 y위치
    Color color;  
    int xSpeed=0;  //라켓이 움직이는 값을 지정
    int ySpeed=0;  //라켓이 움직이는 값을 지정
    private GameBoard game;
    int racekt=0;

    public Racket(GameBoard game, int x, int y, Color color, int racket)
    {
        this.game=game;
        this.x=x;
        this.y=y;
        this.color=color;
        this.racekt=racket; //라켓 1,2를 구분하기 위해서 int 값 1,2로 지정해서 구별해준다.
    }

    public void move()  //라켓의 위치가 0보다 크고 게임 테이블의 높이보다 작을 경우에만 움직일수 있도록
                   //움직이는 값을 더해 준다. 
    {
        if(y + ySpeed > 0 && y+ySpeed < game.getHeight() - HEIGHT)
            y=y+ySpeed;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
    //라켓의 색을 지정하고 x,y의 위치에 WIDTH,HEIGHT크기로 라켓을 그린다.

    public void keyReleased(KeyEvent e) 
    {
        ySpeed=0;
    } 
    //키에서 손을 땠을때 움직이는 값을 0으로 해서 멈추게 한다.

    public void keyPressed(KeyEvent e) 
    //키보드를 눌렀을때 1번 라켓과 2번 라켓을 따로따로 움직이게 하기 위해 1번라켓은 방향키 2번 라켓은 w,s키로 움직이도록 설정
    {
        if(racekt==1)  //racket 값이 1이므로 1번라켓 키를 설정해서 움직이도록 함
        {
            if(e.getKeyCode() == 87)  //W키를 눌렀을때 위로 3만큼 이동
                ySpeed=-3;
            if(e.getKeyCode() == 83)  //S키를 눌렀을때 아래로 3만큼 이동
                ySpeed=3;
        }
        if(racekt==2)  //racket 값이 2이므로 2번라켓 키를 설정해서 움직이도록 함
        {
            if(e.getKeyCode() == KeyEvent.VK_UP)  //방향키 위를 눌렀을때 위로 3만큼 이동
                ySpeed=-3;
            if(e.getKeyCode()== KeyEvent.VK_DOWN)  //방향키 아래를 눌렀을때 아래로 3만큼 이동
                ySpeed=3;
        }
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
    // 라켓의 범위를 구한다.
}