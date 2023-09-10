package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    Loading(String username) {
        this.username = username;
        t = new Thread(this);
        
        setBounds(300, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        
        JLabel text = new JLabel("Ghosh Travel and Tourism");
        text.setBounds(80, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(200, 140, 250, 40);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblusername);
        
        
        t.start();
        setVisible(true);
    }
    
    public void run(){
        try{
           for (int i= 1; i <= 101; i++){
                int max = bar.getMaximum();//100
                int value = bar.getValue();
                
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                }else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(30);
            } 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main (String[] args) {
        new Loading("");
    }
}
