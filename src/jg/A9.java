package jg;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class A9 implements Runnable{
    Rectangle A9;
    int xDirection,yDirection,x,y;
    boolean resting=false;
    boolean shouldSetRandDir=true;
    Image boom;
    public A9(Rectangle r){
        A9=r;
        ImageIcon i=new ImageIcon("a.gif");
        boom=i.getImage();
    }
    public void draw (Graphics g){
        g.setColor(Color.YELLOW);
        if(A9!=null)
            g.drawImage(boom, A9.x, A9.y, null);
        x=A9.x;y=A9.y;
    }
    
    public int choosexRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[3];
        randDirections[0]=-1;
        randDirections[1]=1;;
        randDirections[2]=0;
        int randChoice = r.nextInt(3);
        return randDirections[randChoice];
    }
    public int chooseyRandomDirection(){
        Random r=new Random();
        int[] randDirections=new int[1];
        randDirections[0]=+1;
        int randChoice = r.nextInt(1);
        return randDirections[randChoice];
    }
    
    public void setXDirection(int dir){
        xDirection=dir;
    }
    public void setYDirection(int dir){
        yDirection=dir;
    }
    public void move(){
        if(A9.x>500){
            A9.x=0;
        }
        if(A9.x<0){
            A9.x=500;
        }
        if(A9.y>600){
            A9.y=0;
        }
        if(A9.y<0){
            A9.y=600;
        }
        A9.x+=xDirection;
        A9.y+=yDirection;
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
                        int n=r.nextInt(5)+2;
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

