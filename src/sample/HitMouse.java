package sample;
import javax.swing.*;

public class HitMouse extends JFrame{
    public static void main(String[] args){
        FirstPage app=new FirstPage();
        app.setTitle("Main menu");
        app.setSize(640,480);
        app.setVisible(true);
        app.setLocation(350,200);
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

