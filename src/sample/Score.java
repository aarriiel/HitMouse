package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Score extends JFrame implements ActionListener{
    private int score=0;
    private int click=0;
    private JButton restart,backmenu;
    private int[][] sort;
    private int a[];
    private int b[];
    private String hello;
    private JLabel s;
    private JLabel c;
    private int count=0;
    private DefaultTableModel model = null;
    private JPanel jp;
    private JTable table = null;
    public Score(){};
    public Score(int score,int click) throws IOException {
        this.score = score;
        this.click = click;
    }
    public void result(){
        jp = new JPanel();
        sort=new int[100][2];
        a=new int[100];
        b=new int[100];
        BubbleSort bs = new BubbleSort();
        String[][][] datas = {};
        String[] titles = {"Rank","Score:","Click"};
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        restart=new JButton("Restart");
        backmenu=new JButton("Back Menu");
        s = new JLabel("Your score is :" + score + "  Your click is : " + click);
        s.setFont(new Font("", 1, 30));
        s.setForeground(Color.DARK_GRAY);
        restart.addActionListener(this);
        backmenu.addActionListener(this);
        FileReader fr = null;
        try {
            fr = new FileReader("Result.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((hello = br.readLine()) != null) {
                String[] token = hello.split(",");
                sort[count][0] = Integer.parseInt(token[0]);
                sort[count][1] = Integer.parseInt(token[1]);
                a[count]=sort[count][0];
                b[count]=sort[count][1];
                count++;
            }
            bs.bubblesort(a,b,sort,count);
            bs.selectionSort(a,sort,count);
            int j=1;
            for (int i = 0; i < count; i++) {
                        model.addRow(new String[]{String.valueOf(j), String.valueOf(sort[i][0]), String.valueOf(sort[i][1])});
                        j++;
            }
            add(s, BorderLayout.NORTH);
            add(new JScrollPane(table));
            jp.add(restart);
            jp.add(backmenu);
            add(jp,BorderLayout.SOUTH);
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    public void setScore(int score,int click){
        this.score=score;
        this.click=click;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==restart){
            setVisible(false);
            Mouse app=new Mouse();
            app.setSize(640,480);
            app.setTitle("HitMouse");
            app.setLocation(350,200);
            app.setVisible(true);
            app.setResizable(false);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(e.getSource()==backmenu){
            setVisible(false);
            FirstPage app=new FirstPage();
            app.setTitle("Main menu");
            app.setSize(640,480);
            app.setVisible(true);
            app.setLocation(350,200);
            app.setResizable(false);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
