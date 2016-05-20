package jg;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class A0 implements Runnable{
    Rectangle A0;
    int xDirection,yDirection,x,y;
    boolean resting=false;
    boolean shouldSetRandDir=true;
    Image boom;
    public A0(Rectangle r){
        A0=r;
        ImageIcon i=new ImageIcon("a.gif");
        boom=i.getImage();
    }
    public void draw (Graphics g){
        g.setColor(Color.YELLOW);
        if(A0!=null)
            g.drawImage(boom, A0.x, A0.y, null);
        x=A0.x;y=A0.y;
    }
    
    public int choosexRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[2];
        randDirections[0]=-1;
        int randChoice = r.nextInt(1);
        return randDirections[randChoice];
    }
    public int chooseyRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[3];
        randDirections[0]=-1;
        randDirections[1]=1;;
        randDirections[2]=0;
        int randChoice = r.nextInt(3);
        return randDirections[randChoice];
    }
    
    public void setXDirection(int dir){
        xDirection=dir;
    }
    public void setYDirection(int dir){
        yDirection=dir;
    }
    public void move(){
        if(A0.x>500){
            A0.x=0;
        }
        if(A0.x<0){
            A0.x=500;
        }
        if(A0.y>600){
            A0.y=0;
        }
        if(A0.y<0){
            A0.y=600;
        }
        A0.x+=xDirection;
        A0.y+=yDirection;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                if(!resting){
                    if(shouldSetRandDir){
                        setXDirection(choosexRandomDirection());
                        setYDirection(chooseyRandomDirection());
                        shouldSetRandDir = false;
                    }
                    long start=System.currentTimeMillis();
                    long end = start + 10;
                    while (System.currentTimeMillis()<end){
                        move();
                        Random r=new Random();
                        int n=r.nextInt(3)+2;
                        Thread.sleep(n);
                    }
                    resting = true;
                }
                else{
                    Thread.sleep(0);
                    shouldSetRandDir = true;
                    resting=false;
                }
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}


