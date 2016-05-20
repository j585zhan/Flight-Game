package jg;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class A8 implements Runnable{
    Rectangle A8;
    int xDirection,yDirection,x,y;
    boolean resting=false;
    boolean shouldSetRandDir=true;
    Image boom;
    public A8(Rectangle r){
        A8=r;
        ImageIcon i=new ImageIcon("a.gif");
        boom=i.getImage();
    }
    public void draw (Graphics g){
        g.setColor(Color.YELLOW);
        if(A8!=null)
            g.drawImage(boom, A8.x, A8.y, null);
        x=A8.x;y=A8.y;
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
        if(A8.x>500){
            A8.x=0;
        }
        if(A8.x<0){
            A8.x=500;
        }
        if(A8.y>600){
            A8.y=0;
        }
        if(A8.y<0){
            A8.y=600;
        }
        A8.x+=xDirection;
        A8.y+=yDirection;
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


