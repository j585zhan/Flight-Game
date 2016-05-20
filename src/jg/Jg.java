
package jg;
//10,15,16;
//tracking boom, timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Jg extends JFrame implements Runnable{
    
    Rectangle ball;
    private Image dbI;
    private Graphics dbg;
    Image flight1,flight2,flight3,flight,fb,a1,b1,b2,b3,b0;
    String st="SILVER KILLER";
    boolean gS=false;
    boolean sH;
    boolean dH;
    long stt,ett;
    boolean stop=false;
    Rectangle B1;
    boolean help=false;
    int x,y,xDirection,yDirection;
    int blood=468;
    Rectangle startButton = new Rectangle (175,200,145,35);
    Rectangle dButton = new Rectangle (175,300,145,35);
    static Rectangle o1=new Rectangle(250,100,0,0);
    static Rectangle o2=new Rectangle(250,100,0,0);
    static Rectangle o3=new Rectangle(250,100,0,0);
    static Rectangle o4=new Rectangle(250,100,0,0);
    static Rectangle o5=new Rectangle(250,100,0,0);
    static Rectangle o6=new Rectangle(250,100,0,0);
    static Rectangle o7=new Rectangle(250,100,0,0);
    static Rectangle o8=new Rectangle(250,100,0,0);
    static Rectangle o9=new Rectangle(250,100,0,0);
    static Rectangle o0=new Rectangle(250,100,0,0);
    static Rectangle p=new Rectangle(30,50,25,25);
    static Rectangle e=new Rectangle(275,175,16,16);
    static A1 A1=new A1(o1);
    static A2 A2=new A2(o2);
    static A3 A3=new A3(o3);
    static A4 A4=new A4(o4);
    static A5 A5=new A5(o5);
    static A6 A6=new A6(o6);
    static A7 A7=new A7(o7);
    static A8 A8=new A8(o8);
    static A9 A9=new A9(o9);
    static A0 A0=new A0(o0);
    
    @Override
    public void run(){
        try{
            while(true){
                move();
                
                Thread.sleep(2);
            }
            
        }catch(Exception e){
            System.out.print("error");
        }
    }
    
    public void move(){
        x+=xDirection;
        y+=yDirection;
        if(x<=20)
            x=20;
        if(x>=480)
            x=480;
        if(y<=40)
            y=40;
        if(y>=580)
            y=580;
    }
    
    public void setXDirection(int xdir){
        xDirection=xdir;
    }
    public void setYDirection(int ydir){
        yDirection=ydir;
    }
    
    public Jg(){
        ImageIcon ia=new ImageIcon("b1.gif");
        b1=ia.getImage();
        ImageIcon ib=new ImageIcon("b2.gif");
        b2=ib.getImage();
        ImageIcon ic=new ImageIcon("b3.gif");
        b3=ic.getImage();
        b0=b1;
        ImageIcon i1=new ImageIcon("1.jpg");
        flight1=i1.getImage();
        ImageIcon i2=new ImageIcon("2.jpg");
        flight2=i2.getImage();
        ImageIcon i3=new ImageIcon("3.jpg");
        flight3=i3.getImage();
        flight=flight1;
        ImageIcon u1=new ImageIcon("a.gif");
        a1=u1.getImage();
        this.setTitle("flight");
        this.setSize(500,600);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new AL());
        this.addMouseListener(new ML());
        this.addMouseMotionListener(new ML());
        x=250;y=500;
    }
    
    @Override
    public void paint(Graphics g){
        
        
        dbI=createImage(getWidth(),getHeight());
        dbg=dbI.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbI,0,0,this);
        g.setColor(Color.red);
        if(blood==0){
            g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD,30));
                g.drawString("GAME OVER", 170, 300);
        }
    }
    
    public void paintComponent(Graphics g){
        
        if(!gS){
            if(!help){
            this.setBackground(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD,26));
            g.setColor(Color.WHITE);
            g.drawString("FLIGHT GAME",155,100);
            if(!sH){
                g.setColor(Color.CYAN);}
            else{
                g.setColor(Color.PINK);}
            g.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
            g.setFont(new Font("Arial", Font.BOLD,16));
            g.setColor(Color.GRAY);
            g.drawString("Start Game (S)", 195,225);
            if(!dH){
                g.setColor(Color.CYAN);}
            else{
                g.setColor(Color.PINK);}
            g.fillRect(dButton.x, dButton.y, dButton.width, dButton.height);
            g.setFont(new Font("Arial", Font.BOLD,16));
            g.setColor(Color.GRAY);
            g.drawString("Help (H)", 215,325);
            g.drawImage(a1, 400, 500, this);}
            else
            {
                g.setColor(Color.GRAY);
                g.fillRoundRect(50, 100, 400, 400,30,30);
                g.setFont(new Font("Arial", Font.BOLD,30));
                g.setColor(Color.BLACK);
                g.drawString("HELP", 200, 150);
                g.setFont(new Font("Arial", Font.BOLD,16));
                g.setColor(Color.BLACK);
                g.drawString("1. In this game, you need to use up, down, ", 75, 200);
                g.drawString("left or right to control the warcraft to avoid", 75, 230);
                g.drawString("the booms.", 75, 260);
                g.drawString("2. You may use 1, 2, or 3 to switch to other", 75, 290);
                g.drawString("warcraft.", 75, 320);
                g.drawString("3. (B) to (B)ack to the index page", 75, 350);
                g.drawString("4. (S) to (S)tart game directly", 75, 380);
                }
        }
        else{
            if(blood!=0&&ett-stt!=30000){
                

                ett=System.currentTimeMillis();
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial",Font.BOLD,40));
                g.drawString(Long.toString((ett-stt)/1000), 400, 100);
                
                if(!((x>A1.x&&x<A1.x+50&&y>A1.y+20&&y<A1.y+70)||(x>A2.x&&x<A2.x+50&&y>A2.y+20&&y<A2.y+70)||(x>A3.x&&x<A3.x+50&&y>A3.y+20&&y<A3.y+70)||(x>A4.x&&x<A4.x+50&&y>A4.y+20&&y<A4.y+70)||(x>A5.x&&x<A5.x+50&&y>A5.y+20&&y<A5.y+70)||(x>A6.x&&x<A6.x+50&&y>A6.y+20&&y<A6.y+70)||(x>A7.x&&x<A7.x+50&&y>A7.y+20&&y<A7.y+70)||(x>A8.x&&x<A8.x+50&&y>A8.y+20&&y<A8.y+70)||(x>A9.x&&x<A9.x+50&&y>A9.y+20&&y<A9.y+70)||(x>A0.x&&x<A0.x+50&&y>A0.y+20&&y<A0.y+70))){
                g.drawImage(flight, x, y, this);
                }
                if((x>A1.x&&x<A1.x+50&&y>A1.y+20&&y<A1.y+70)||(x>A2.x&&x<A2.x+50&&y>A2.y+20&&y<A2.y+70)||(x>A3.x&&x<A3.x+50&&y>A3.y+20&&y<A3.y+70)||(x>A4.x&&x<A4.x+50&&y>A4.y+20&&y<A4.y+70)||(x>A5.x&&x<A5.x+50&&y>A5.y+20&&y<A5.y+70)||(x>A6.x&&x<A6.x+50&&y>A6.y+20&&y<A6.y+70)||(x>A7.x&&x<A7.x+50&&y>A7.y+20&&y<A7.y+70)||(x>A8.x&&x<A8.x+50&&y>A8.y+20&&y<A8.y+70)||(x>A9.x&&x<A9.x+50&&y>A9.y+20&&y<A9.y+70)||(x>A0.x&&x<A0.x+50&&y>A0.y+20&&y<A0.y+70)){
                    stop=true;
                    g.drawImage(b0, x-50, y-50, this);

                    blood--;
                }
                g.setFont(new Font("Arial",Font.BOLD,12));
                g.setColor(Color.WHITE);
                g.drawString(st, 20, 580);
                g.setColor(Color.RED);
                g.drawString("(B) to BACK", 400, 580);
                A1.draw(g);
                A2.draw(g);
                A3.draw(g);
                A4.draw(g);
                A5.draw(g);
                A6.draw(g);
                A7.draw(g);
                A8.draw(g);
                A9.draw(g);
                A0.draw(g);
                g.drawRoundRect(20, 80, 20, 470, 30, 30);
                g.setColor(Color.red);
                g.fillRoundRect(21, 81+468-blood, 19, blood, 30, 30);
                
            }else if(blood!=0&&ett-stt==30000){this.setBackground(Color.red.darker());
                g.setColor(Color.WHITE);
                long score=(ett-stt)/1000;
                g.drawString("WIIIIIN!!!!!", 200, 250);
                g.setColor(Color.gray);
                g.setFont(new Font("Arial", Font.BOLD,15));
                g.drawString("(B) to try again", 190, 350);}
            else{
                this.setBackground(Color.red.darker());
                g.setColor(Color.WHITE);
                long score=(ett-stt)/1000;
                g.drawString("Your Score: "+Long.toString(score), 200, 250);
                g.setColor(Color.gray);
                g.setFont(new Font("Arial", Font.BOLD,15));
                g.drawString("(B) to try again", 190, 350);
                }
        }
            repaint();
    }
    
    public static void main(String[] args) {
            Jg jg=new Jg();
            
           
            Thread t=new Thread(jg);
            t.start();
            
            Thread t1=new Thread(A1);
            t1.start();
            Thread t2=new Thread(A2);
            t2.start();
            Thread t3=new Thread(A3);
            t3.start();
            Thread t4=new Thread(A4);
            t4.start();
            Thread t5=new Thread(A5);
            t5.start();
            Thread t6=new Thread(A6);
            t6.start();
            Thread t7=new Thread(A7);
            t7.start();
            Thread t8=new Thread(A8);
            t8.start();
            Thread t9=new Thread(A9);
            t9.start();
            Thread t0=new Thread(A0);
            t0.start();
    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int keyCode=e.getKeyCode();
            if(keyCode==e.VK_LEFT){
                setXDirection(-1);
            }
            if(keyCode==e.VK_RIGHT){
                setXDirection(+1);
            }
            if(keyCode==e.VK_UP){
                setYDirection(-1);
            }
            if(keyCode==e.VK_DOWN){
                setYDirection(+1);
            }
            if(keyCode==e.VK_1){
                flight=b1;
                st="SILVER KILLER";
            }
            if(keyCode==e.VK_2){
                flight=b2;
                st="J18";
            }
            if(keyCode==e.VK_3){
                flight=b3;
                st="GOLDEN FISH";
            }
            if(keyCode==e.VK_S){
                sH=true;
                gS=true;
                
            stt=System.currentTimeMillis();
            }
            if(keyCode==e.VK_B){
                gS=false;
                blood=468;
                help=false;
                x=250;
                y=500;
            }
            if(keyCode==e.VK_H){
                help=true;
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
            int keyCode=e.getKeyCode();
            if(keyCode==e.VK_LEFT){
                setXDirection(0);
            }
            if(keyCode==e.VK_RIGHT){
                setXDirection(0);
            }
            if(keyCode==e.VK_UP){
                setYDirection(0);
            }
            if(keyCode==e.VK_DOWN){
                setYDirection(0);
            }
            if(keyCode==e.VK_1){
                flight=flight1;
                b0=b1;
            }
            if(keyCode==e.VK_2){
                flight=flight2;
                b0=b2;
            }
            if(keyCode==e.VK_3){
                flight=flight3;
                b0=b3;
            }
            if(keyCode==e.VK_S){
                sH=false;
            }
        }
    }
        public class ML extends MouseAdapter{
            
            @Override
            public void mouseMoved(MouseEvent e){
                int mx=e.getX();
                int my=e.getY();
                if(mx>startButton.x && mx<startButton.x+startButton.width &&my>startButton.y && my<startButton.y+startButton.height){
                    sH=true;
                }else sH=false;
                if(mx>dButton.x && mx<dButton.x+dButton.width &&my>dButton.y && my<dButton.y+dButton.height){
                    dH=true;
                }else dH=false;
            }
            @Override
            public void mousePressed (MouseEvent e){
                int mx=e.getX();
                int my=e.getY();
                if(mx > startButton.x && mx < startButton.x+startButton.width && my> startButton.y && my<startButton.y+startButton.height)
                {gS=true;
            stt=System.currentTimeMillis();}
                if(mx > dButton.x && mx < dButton.x+dButton.width && my> dButton.y && my<dButton.y+dButton.height)
                {help=true;}
            }
            @Override
            public void mouseReleased (MouseEvent e){
                
            }
        }
    }