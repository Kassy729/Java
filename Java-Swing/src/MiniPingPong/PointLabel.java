package MiniPingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//점수판 라벨
public class PointLabel extends JLabel{ 
    
    private int point1=0;
    private int point2=0;   // 초기화가 안될수도 있어서 0으로 초기화
    public PointLabel()
    {
        this.setText("0 : 0");  
    }
    //처음 점수판을 0:0으로 설정한다

    void setPoint(int point1, int point2)
    {
        this.point1=point1;
        this.point2=point2;        
    }
    //생성사를 통해 점수를 받아온다.

    void setPointPanel()
    {
        this.setText(point1 + " : " + point2);
    }
    //받아온 점수를 화면에 보여준다.
}