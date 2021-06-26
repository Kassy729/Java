package MiniPingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball {
    private static final int RADIUS=20;
    int x=0;  //공의 x좌표 위치
    int y=0;  //공의 y좌표 위치
    int xSpeed=1;  //공을 이동시키는 값
    int ySpeed=1;  //공을 이동시키는 값
    private GameBoard game;  
    private PointLabel point;
    Color color;
    int speed=1;  //공의 속도를 높일때 사용하는 변수
    int point1=0;  
    int point2=0;  
    //스코어를 나태내기 위해 사용

    public Ball(GameBoard game, Color color)
    {
        this.game=game;
        this.color=color;
    }

    void move()
    {
        if(x<0)  //공의 x위치가 0보다 작아지면 벽에 닿는 경우 이므로 게임 reset()과 상대편 포인트를 올려준다.
        {
            reset();   // 양쪽 벽에 공이 닿으면 게임이 초기화
            point2++;  // 상대편에 점수 +1
            System.out.println("B팀 승리!!");
        }
         
        if(x>=game.getWidth() - 2*RADIUS)  //공의 x위치가 테이블 오른쪽 크기보다 클 경우도 벽에 닿으므로
                                   //게임 reset과 상대편 포인트를 올려준다.
        {
            reset();   // 양쪽 벽에 공이 닿으면 게임이 초기화
            point1++;  // 상대편에 점수 +1
            System.out.println("A팀 승리!!");
        }
            
        if(y<0)  //공의 y위치가 0보다 작을 경우 윗 벽에 닿으므로 튕겨서 반대편으로 가게 만들어야한다
        {
            ySpeed=-(ySpeed);  //공이 벽에 닿으면 반대편으로 가도록 공의 위치 값을 음수로 바꿔준다.
        }
           
        if(y>= game.getHeight() -2*RADIUS)
        {
            ySpeed=-(ySpeed);  //공의 y위치가 0보다 작을 경우 아랫 벽에 닿으므로 튕겨서 반대편으로 가게 만들어야한다
        }
            
        if(collision())
        {
            // 서로의 막대기에 공이 닿았을때 공의 속력을 높여줌
            if(xSpeed>=0)
                xSpeed-=speed;
            else
                xSpeed+=speed;
            
            if(ySpeed>=0)
                ySpeed+=speed/2;
            else
                ySpeed-=speed/2;
            speed++;        // 속력이 점점 증가 
        }
        
        x = x+xSpeed;
        y = y+ySpeed;
    }

    private boolean collision()
    {
        return game.racket1.getBounds().intersects(getBounds()) || game.racket2.getBounds().intersects(getBounds());
    } 
    //라켓의 범위를 getBounds()로 얻어와서 공의 범위와 겹치면 true값을 반환해준다.

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval(x,y,2*RADIUS, 2*RADIUS);
    }
    //공의 색을 지정하고 x,y의 위치에 RADIUS*2만큼의 크기로 그려준다.

    public Rectangle getBounds()
    {
        return new Rectangle(x,y,2*RADIUS, 2*RADIUS);
    }
   
    public void reset() //게임을 리셋시키기 위해 만든 메소드
    {
        x=0;
        y=0;
        xSpeed=1;
        ySpeed=1;
        speed=1;
    }

    int getPoint1()   // 점수판에 쓰일 점수를 호출하는 메소드
    {
        return point1;
    }
    int getPoint2()
    {
        return point2;
    }
}
