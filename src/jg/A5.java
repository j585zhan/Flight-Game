package jg;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class A5 implements Runnable{
    Rectangle A5;
    int xDirection,yDirection,x,y;
    boolean resting=false;
    boolean shouldSetRandDir=true;
    Image boom;
    public A5(Rectangle r){
        A5=r;
        ImageIcon i=new ImageIcon("a.gif");
        boom=i.getImage();
    }
    public void draw (Graphics g){
        g.setColor(Color.YELLOW);
        if(A5!=null)
            g.drawImage(boom, A5.x, A5.y, null);
        x=A5.x;y=A5.y;
    }
    
    public int choosexRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[2];
        randDirections[0]=-1;
        randDirections[1]=1;;
        int randChoice = r.nextInt(2);
        return randDirections[randChoice];
    }
    public int chooseyRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[2];
        randDirections[0]=-1;
        randDirections[1]=1;;
        int randChoice = r.nextInt(2);
        return randDirections[randChoice];
    }
    
    public void setXDirection(int dir){
        xDirection=dir;
    }
    public void setYDirection(int dir){
        yDirection=dir;
    }
    public void move(){
        if(A5.x>500){
            A5.x=0;
        }
        if(A5.x<0){
            A5.x=500;
        }
        if(A5.y>600){
            A5.y=0;
        }
        if(A5.y<0){
            A5.y=600;
        }
        A5.x+=xDirection;
        A5.y+=yDirection;
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
                    long end = start + 1000;
                    while (System.currentTimeMillis()<end){
                        move();
                        Thread.sleep(5);
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

