package bet.game.oop.ua5.gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Math.*;


class gach extends obj{
    final double minngang = (double) width / 2;
    final double mindoc = (double) height / 2;
    int centralX = x + this.width / 2 ;
    int centralY = y + this.height / 2 ;

    int hp;


    gach(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.hp = 1;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.centralX = x + this.width / 2;
        this.centralY = y + this.height / 2;
    }
    gach() {

    }

    public int getWidth() {
        width = img.getWidth(null);
        return width;
    }

    public int getHeight() {
        height = img.getHeight(null);
        return height;
    }


}

class ktvc {
    public boolean vc(){
        return true;
    }
}

abstract class obj {
    int centralX;
    int centralY;
    int x;
    int y;
    Image img;
    int width;
    int height;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class ball extends obj {
    double centralX = x + width / 2 ;
    double centralY =  y + height / 2;
    public ball(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.centralX = x + width / 2;
        this.centralY = y + width / 2;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public double ObjballX(obj obj) {

        return this.centralX - obj.centralX;
    }

    public double ObjballY(obj obj) {
        return this.centralY - obj.centralY;
    }

    public double khoangcach(gach gach) {
        this.centralX = x + width / 2;
        this.centralY = y + height / 2;
        double ObjBallX = this.centralX - gach.centralX;
        double ObjBallY = this.centralY - gach.centralY;

        double kcObjBall = sqrt(ObjBallX * ObjBallX + ObjBallY * ObjBallY);
        System.out.println(this.centralX + " " + gach.centralX +  " " + ObjBallX);
        System.out.println(this.centralY + " " + gach.centralY +   " " + ObjBallY);
        System.out.println(ObjBallX + " " + ObjBallY + " " + kcObjBall);
        return kcObjBall;
    }

    public double khoangcach(pad gach) {
        this.centralX = x + width / 2;
        this.centralY = y + height / 2;
        gach.centralX = gach.x + gach.width / 2;
        gach.centralY = gach.y + gach.height / 2;
        double ObjBallX = this.centralX - gach.centralX;
        double ObjBallY = this.centralY - gach.centralY;

        double kcObjBall = sqrt(ObjBallX * ObjBallX + ObjBallY * ObjBallY);
        System.out.println(this.centralX + " " + gach.centralX +  " " + ObjBallX);
        System.out.println(this.centralY + " " + gach.centralY +   " " + ObjBallY);
        System.out.println(ObjBallX + " " + ObjBallY + " " + kcObjBall);
        return kcObjBall;
    }

    /*void huongvc(obj obj, boolean balltrai, boolean balltren) {
        if (this.centralX+this.width/2 <= obj.x && this.centralY-this.height/2 <= obj.y && this.centralY+this.height/2 >= obj.y+obj.height/2) {
            balltrai = true;
            balltren = false;
        }
    }*/

}

class pad extends obj {
    pad(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
}

class controlepanel extends JPanel implements ActionListener, KeyListener {

    Font betfont = new Font("Arial", Font.BOLD, 20);

    Timer bettimer = new Timer(16, this);
    double de_x = 0;


    Image gach = new ImageIcon("src/pic/gach.png").getImage();

    Image ball_i = new ImageIcon("src/pic/ball30.png").getImage();
    Image pad_i = new ImageIcon("src/pic/pad.png").getImage();
    pad pad = new pad((900-pad_i.getWidth(null))/2, 800 - pad_i.getHeight(null) , pad_i);
    ball ball = new ball(pad.x+pad.width/2 - 30/2, pad.y - 30, ball_i);
    gach[] gachs = new gach[20];

   /* int ball.x = (900-pad)/2;
    int pad.y = 800 - pad.getHeight(null) - 30; //-30 do khi thu nhor man hinh mat di 30px
    int x_ball = ball.x + pad.getWidth(null) / 2 - 30 / 2;
    int ball.y = pad.y - 30;
    boolean x_phai = true;
    boolean y_len = true;*/
    int x_p_v = 0;
    StringBuilder re = new StringBuilder();

    double vx = 5;
    double vy = -5;


    boolean start = false;

    boolean balltrai = true;
    boolean balltren = true;

    boolean xaygach = false;

    boolean vacham = true;

    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bettimer.start();
        for (int i = 0; i < gachs.length; i++) {
            if (!xaygach) {
                if (i == 0) {
                    gachs[i] = new gach(0, 500, gach);

                } else {
                    if (gachs[i - 1].x + gachs[i - 1].getWidth() * 2 <= 900) {
                        gachs[i] = new gach(gachs[i - 1].x + gachs[i - 1].getWidth(), gachs[i - 1].y, gach);
                    } else {
                        gachs[i] = new gach(0, gachs[i - 1].y + gachs[i - 1].getHeight(), gach);
                    }

                }
                System.out.println(gachs[i].x + " " + gachs[i].y + " " + gachs[i].centralX + " " + gachs[i].centralY) ;
            }

        }
        if (!xaygach) {
            xaygach = true;
        }




        for (int i = 0; i < gachs.length; i++) {




            if (gachs[i].hp > 0) {
                g.drawImage(gachs[i].img, gachs[i].x, gachs[i].y,null);

            }

        }

        g.setColor(Color.green);
        g.drawRect(0,0,900,800);
        g.setColor(Color.white);
        g.fillOval(ball.x, ball.y, 30, 30);
        /*
        g.setFont(betfont);
        g.setColor(Color.white);
        g.drawString("sigmaboy", 50, 50);

        g.setColor(Color.CYAN);
        g.fillRect((900 - 250) / 2,0, 250, 50); //fill
        g.drawRect((900 - 250) / 2,100, 250, 35);  //draw
        g.setColor(Color.RED);
        g.drawOval((900 - 250) / 2,100, 50, 50);
        g.fillOval((900 - 250) / 2 + 50,100, 50, 50);
        g.drawImage(ball,0,0,null);*/

        g.drawImage(pad_i, pad.x, pad.y, null);

        g.dispose(); // sau khi dung xong thi xoa
        //System.out.println("j̣97");
    }

    double canx = 0;
    double cany = 0;

    boolean vachamp = true;

    @Override public void actionPerformed(ActionEvent e) {

        if(!start) {
            ball.x = pad.x + pad.width / 2 - 30 /2 ;
            ball.y = pad.y - 30;
        } else {
            ball.x += vx - canx;
            ball.y += vy - cany;
            ball.centralX = ball.x + ball.width / 2;
            ball.centralY = ball.y + ball.height/2;
        }

        if (start) {
            if (ball.x >= 900-ball.width) {
                vx *= -1;
                ball.x = 900 -ball.width;
            } else if(ball.x <= 0) {
                vx *= -1;
                ball.x = 0;
            }
            if  (ball.y >= 800-ball.height) {
                vy *= -1;
                ball.y = 800-ball.height;
            } else if(ball.y <= 0) {
                vy *= -1;
                ball.y = 0;
            }

            for (int i = 0; i < gachs.length; i++) {
                if (gachs[i].hp > 0 && vachamp) {
                    double KC = (double) ball.width /2 + sqrt((gachs[i].width*gachs[i].width)+(gachs[i].height*gachs[i].height))/2;
                    double kc = ball.khoangcach(gachs[i]);
                    double giao = 1;

                    if ((abs(ball.centralX - gachs[i].x) == abs(ball.centralY - gachs[i].y) && abs(ball.centralX - gachs[i].x) == ball.width/2)
                            || (abs(ball.centralX - gachs[i].x) == abs(ball.centralY - (gachs[i].y - gachs[i].height )) && abs(ball.centralX - gachs[i].x) == ball.width/2)
                            || (abs(ball.centralX - gachs[i].x - gachs[i].width) == abs(ball.centralY - gachs[i].y) && abs(ball.centralX - gachs[i].x - gachs[i].width) == ball.width/2)
                            || (abs(ball.centralX - gachs[i].x - gachs[i].width) == abs(ball.centralY - gachs[i].y - gachs[i].height) && abs(ball.centralX - gachs[i].x - gachs[i].width) == ball.width/2)) {

                        if (kc <= KC) {
                            vacham = false;
                            gachs[i].hp --;
                            vx *= -1;
                            vy *= -1;

                            System.out.println(i + " " +kc+"j"+ KC);
                        }


                    } else if (kc < KC) { // dieu kien cac gach sap va cham
                        if (ball.centralY >= gachs[i].y && ball.centralY <= gachs[i].y + gachs[i].height ) {

                            if (abs(gachs[i].x -ball.centralX) <= abs(gachs[i].x + gachs[i].width - ball.centralX)) {
                                giao = gachs[i].x - ball.centralX;

                            } else if (abs(gachs[i].x -ball.centralX) > abs(gachs[i].x + gachs[i].width - ball.centralX)) {
                                giao = gachs[i].x + gachs[i].width - ball.centralX;
                            }
                            if (abs(giao) <= ball.width/2) {
                                vacham = false;
/*
                                if (vx > 0) {
                                    ball.x = gachs[i].x - ball.width;
                                } else if (vx < 0) {
                                    ball.x = gachs[i].x + ball.width;
                                }

                                ball.centralX = pad.x + ball.width/2;*/
                                gachs[i].hp--;
                                vx *= -1;


                                System.out.println(i + "  9 " + kc + "<" + KC);
                            }


                        } else if (ball.centralX >= gachs[i].x && ball.centralX <= gachs[i].x + gachs[i].width) {


                            if (abs(gachs[i].y -ball.centralY) <= abs(gachs[i].y + gachs[i].height - ball.centralY)) {
                                giao = gachs[i].y - ball.centralY;

                            } else if (abs(gachs[i].y -ball.centralY) > abs(gachs[i].y + gachs[i].height - ball.centralY)) {
                                giao = gachs[i].y + gachs[i].height - ball.centralY;
                            }
                            if (abs( giao) <= ball.width/2) {
                                vacham = false;
                                /*if (vy > 0) {
                                    ball.y  = gachs[i].y - ball.height;
                                } else if (vy < 0) {
                                    ball.y  = gachs[i].y + ball.height;
                                }

                                ball.centralY = ball.y + ball.width/2;*/

                                gachs[i].hp--;
                                vy *= -1;

                                System.out.println(i + " 7 " + kc + "< " + KC);

                            }

                        }
                    } /*else if (kc == ball.width + sqrt(gachs[i].width*gachs[i].width+gachs[i].height*gachs[i].height)) {

                }*/
                }
                }

            if (vachamp) {
                double KCp = (double) ball.width / 2 + sqrt((pad.width * pad.width) + (pad.height * pad.height)) / 2;
                double kcp = ball.khoangcach(pad);

                if ((abs(ball.centralX - pad.x) == abs(ball.centralY - pad.y) && abs(ball.centralX - pad.x) == ball.width / 2)
                        || (abs(ball.centralX - pad.x) == abs(ball.centralY - (pad.y - pad.height)) && abs(ball.centralX - pad.x) == ball.width / 2)
                        || (abs(ball.centralX - pad.x - pad.width) == abs(ball.centralY - pad.y) && abs(ball.centralX - pad.x - pad.width) == ball.width / 2)
                        || (abs(ball.centralX - pad.x - pad.width) == abs(ball.centralY - pad.y - pad.height) && abs(ball.centralX - pad.x - pad.width) == ball.width / 2)) {

                    if (kcp <= KCp) {
                        vachamp = false;
                        vx *= -1;
                        vy *= -1;

                        System.out.println(kcp + "j" + KCp);
                    }



                } else if (kcp < KCp) { // dieu kien cac gach sap va cham
                    double giaop = -9999999;
                    if (ball.centralY >= pad.y && ball.centralY <= pad.y + pad.height) {


                        if (abs(pad.x - ball.centralX) <= abs(pad.x + pad.width - ball.centralX)) {
                            giaop = pad.x - ball.centralX;

                        } else if (abs(pad.x - ball.centralX) > abs(pad.x + pad.width - ball.centralX)) {
                            giaop = pad.x + pad.width - ball.centralX;
                        }
                        if (abs(giaop) <= ball.width / 2 ) {
/*
                        if (vx > 0) {
                            ball.x = pad.x - ball.width;
                        } else if (vx < 0) {
                            ball.x = pad.x + ball.width;
                        }


                        ball.centralX = ball.x + ball.width / 2;*/
                            vachamp = false;
                            vx *= -1;



                            System.out.println("  9 " + kcp + "<" + KCp);
                        }


                    } else if (ball.centralX >= pad.x && ball.centralX <= pad.x + pad.width) {


                        if (abs(pad.y - ball.centralY) <= abs(pad.y + pad.height - ball.centralY)) {
                            giaop = pad.y - ball.centralY;

                        } else if (abs(pad.y - ball.centralY) > abs(pad.y + pad.height - ball.centralY)) {
                            giaop = pad.y + pad.height - ball.centralY;
                        }
                        if (abs(giaop) <= ball.width / 2 ) {
/*
                        if (vy > 0) {
                            ball.y = pad.y - ball.height;
                        } else if (vy < 0) {
                            ball.y = pad.y + ball.height;
                        }
                        ball.centralY = ball.y + ball.height/2;*/
                            vachamp = false;
                            vy *= -1;

                            System.out.println(" 7 " + kcp + "< " + KCp);

                        }

                    }

                }
            }


        }







        //System.out.println(pad.x + " " + pad.y);
        repaint();
        vacham = true;
        vachamp = true;
    }

    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R || e.getKeyCode() == KeyEvent.VK_E) {
            re.append(e.getKeyChar());
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W");

            pad.y = pad.y - 20;
            pad.centralY = pad.y + pad.height/2;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S");
            pad.y = pad.y + 20;
            pad.centralY = pad.y +pad.height/2;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A");
            if (x_p_v < 30) {
                x_p_v = x_p_v + 15;
            }
            if (pad.x - 5 - x_p_v >=0) {
                pad.x = pad.x - 5 - x_p_v;
            } else if (ball.x > 0) {
                pad.x = 0;
            }
            pad.centralX = pad.x + pad.width/2;

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D");
            if (x_p_v < 30) {
                x_p_v = x_p_v + 15;
            }

            if (pad.x + 5 + x_p_v <=900-pad.width) {
                pad.x = pad.x + 5 + x_p_v;
            } else if (pad.x < 900-pad.width) {
                pad.x = 900-pad.width;
            }
            pad.centralX = pad.x + pad.width/2 ;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            start = true;
        }
    }

    @Override public void keyReleased(KeyEvent e) {

        x_p_v = 0;

    }

    @Override public void keyTyped(KeyEvent e) {

        System.out.println(re.toString());

        if (re.toString().equals("re")) {
            re.delete(0, re.length());
            ball.x = ball.x + 50;
            ball.y = 500;

        } if (re.length() >= 2) {
            if (!re.toString().equals("re")) {
                re.delete(0, re.length());
            }
        }

    }

    public controlepanel() {

        this.setFocusable(true); //tap trung vao cua so
        this.setDoubleBuffered(true); // chay muot hon ?
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.addKeyListener(this);
    }


}
public class bframe extends JFrame {

    public static final int win_width = 915;
    public static final int win_height = 830;

    controlepanel betpanel = new controlepanel();
    public int betframe() {

        this.setTitle("Hello Swing");
        this.add(betpanel);

        this.setSize(915, 830);  //set size 915X830
        //this.pack();
        this.setVisible(true);  //set visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //set khi dung chuong trinh dung jframe
        this.setLocationRelativeTo(null);   //ra giua man hinh
        this.setResizable(true); // ko cho phep thay doi kich co



        return 0;
    }


}

