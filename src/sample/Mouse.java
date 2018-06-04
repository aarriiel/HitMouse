package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Mouse extends JFrame implements ActionListener,MouseListener{
    private Container c;
    private JButton start, stop;
    private JLabel lasttime, countscore, end, number;
    private java.util.Random rand;
    private int x1, y1, x2, y2, x3, x4, x5, mode, score, click;
    private double time;
    private javax.swing.Timer t,timer;
    private Image image;
    private Image image1;
    Score sc=new Score();
    private Cursor cr;
    private Cursor cr1;
    private int count=0;
    public Mouse() {
        click = 0;
        x1 = 200;
        x2 = 400;
        x3 = 150;
        x4 = 300;
        x5 = 450;
        y1 = 200;
        y2 = 350;
        mode = 0;
        time = 30;
        score = 0;
        setLocation(350,200);
        rand = new Random();
        c = getContentPane();
        c.setLayout(new FlowLayout());
        start = new JButton("Start");
        stop = new JButton("Stop");
        lasttime = new JLabel("Time:"+time+"s");
        countscore = new JLabel("Score:0");
        number = new JLabel("Click:0");
        end = new JLabel("");
        c.add(lasttime);
        c.add(start);
        c.add(stop);
        c.add(countscore);
        c.add(number);
        c.add(end);
        t = new javax.swing.Timer(500, this);
        start.addActionListener(this);
        stop.addActionListener(this);
        addMouseListener(this);
        image= new ImageIcon("hammer.png").getImage();
        cr = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0) ,"MyCursor" );
        image1= new ImageIcon("hammer1.png").getImage();
        cr1 = Toolkit.getDefaultToolkit().createCustomCursor(image1, new Point(0,0) ,"MyCursor" );
        setCursor( cr );
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image image = Toolkit.getDefaultToolkit().getImage("experiment.png");
        g.drawOval(x3 - 50, y1 - 50, 100, 100);
        g.drawOval(x4 - 50, y1 - 50, 100, 100);
        g.drawOval(x5 - 50, y1 - 50, 100, 100);
        g.drawOval(x1 - 50, y2 - 50, 100, 100);
        g.drawOval(x2 - 50, y2 - 50, 100, 100);
        if (mode == 1) {
            g.setColor(Color.CYAN);
            g.drawImage(image, x3 - 40, y1 - 40, 70, 70, this);
        } else if (mode == 2) {
            g.setColor(Color.BLACK);
            g.drawImage(image, x4 - 40, y1 - 40, 70, 70, this);
        } else if (mode == 3) {
            g.setColor(Color.RED);
            g.drawImage(image, x5 - 40, y1 - 40, 70, 70, this);
        } else if (mode == 4) {
            g.setColor(Color.YELLOW);
            g.drawImage(image, x1 - 40, y2 - 40, 70, 70, this);
        } else if (mode == 5) {
            g.setColor(Color.GREEN);
            g.drawImage(image, x2 - 40, y2 - 40, 70, 70, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            t.start();
        }
        else if (e.getSource() == stop) {
            t.stop();
            mode = 0;
            repaint();
        }
        else if (e.getSource() == t) {
            if (time == 0) {
                t.stop();
                end.setText("Game is End!Click any to see your score.");
            } else {
                time = time - 0.5;
                mode = rand.nextInt(5) + 1;
                lasttime.setText("Time:" + time + "s");
                repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setCursor( cr1 );
        if (time == 0) {
            FileWriter fw = null;
            try{
                fw = new FileWriter("result.txt",true);
                fw.write(score+ "," + click + "\r\n");
                fw.flush();
                fw.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            setVisible(false);
            sc.setScore(score,click);
            sc.setSize(640, 480);
            sc.setVisible(true);
            sc.setTitle("Score");
            sc.setLocation(350,200);
            sc.setResizable(false);
            sc.result();
            sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        click++;
        number.setText("Click:" + click);
        int x, y;
        x = e.getX();
        y = e.getY();
        if (mode == 1) {
            if ((x3 - x) * (x3 - x) + (y - y1) * (y - y1) < 2500) {
                score = score + 1;
                mode = 0;
                countscore.setText("Score" + score);
                repaint();
            }
        } else if (mode == 2) {
            if ((x4 - x) * (x4 - x) + (y1 - y) * (y1 - y) < 2500) {
                score = score + 1;
                countscore.setText("Score:" + score);
                mode = 0;
                repaint();
            }
        } else if (mode == 3) {
            if ((x5 - x) * (x5 - x) + (y1 - y) * (y1 - y) < 2500) {
                score = score + 1;
                countscore.setText("Score:" + score);
                mode = 0;
                repaint();
            }
        } else if (mode == 4) {
            if ((x1 - x) * (x1 - x) + (y2 - y) * (y2 - y) < 2500) {
                score = score + 1;
                countscore.setText("Score:" + score);
                mode = 0;
                repaint();
            }
        } else if (mode == 5) {
            if ((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y) < 2500) {
                score = score + 1;
                countscore.setText("Score:" + score);
                mode = 0;
                repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor( cr);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}