package sample;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage extends JFrame implements ActionListener {
    private JButton start;
    private JButton score;
    private Container c;
    private JPanel p;
    private JPanel panel;
    private JPanel panel1;
    private JLabel label;
    public FirstPage(){
        start=new JButton("Start");
        score=new JButton("Score");
        p=new JPanel();
        panel=new JPanel();
        panel1=new JPanel();
        label=new JLabel("Hit Mouse :D");
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.MAGENTA);
        start.addActionListener(this);
        score.addActionListener(this);
        c = getContentPane();
        p.add(label);
        panel.add(start);
        panel1.add(score);
        c.setLayout(new GridLayout(3,1));
        c.add(p);
        c.add(panel);
        c.add(panel1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==start){
            setVisible(false);
            Mouse app=new Mouse();
            app.setSize(640,480);
            app.setLocation(350,200);
            app.setTitle("HitMouse");
            app.setVisible(true);
            app.setResizable(false);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if (e.getSource()==score){
            setVisible(false);
            Score sc=new Score();
            sc.setSize(640, 480);
            sc.setVisible(true);
            sc.setTitle("Score");
            sc.setLocation(350,200);
            sc.result();
            sc.setResizable(false);
            sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
