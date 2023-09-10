package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;



public class CheckPackage extends JFrame implements ActionListener{
    
    
    CheckPackage (){
        setBounds(300, 100, 900, 600);
        
        String[] package1 = {"GOLD PACKAGE", "7 Days And 7 Nights", "Airport Assistance","City Tour", "Daily Buffet", "Welcome Drinks On Arrival","Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW","SUMMER SPECIAL", "Rs. 20000/-", "icons/package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "5 Days And 5 Nights", "Airport Assistance","City Tour", "Daily Buffet", "Welcome Drinks On Arrival","Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW","WINTER SPECIAL", "Rs. 15000/-", "icons/package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "3 Days And 3 Nights", "Airport Assistance","City Tour", "Daily Buffet", "Welcome Drinks On Arrival","Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW","MONSOON SPECIAL", "Rs. 10000/-","icons/package3.jpg"};
        
        
        JTabbedPane tab = new JTabbedPane(); 
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        add(tab);
        
        
        
        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel (pack[0]);
        l1.setBounds(350, 5, 300, 25);
        l1.setForeground(new Color(252, 182, 3));
        l1.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l1);
        
        JLabel l2 = new JLabel (pack[1]);
        l2.setBounds(50, 60, 300, 30);
        l2.setForeground(new Color(71, 204, 202));
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);
        
        JLabel l3 = new JLabel (pack[2]);
        l3.setBounds(50, 110, 300, 30);
        l3.setForeground(new Color(120, 71, 204));
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);
        
        JLabel l4 = new JLabel (pack[3]);
        l4.setBounds(50, 160, 300, 30);
        l4.setForeground(new Color(71, 204, 202));
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l4);
        
        JLabel l5 = new JLabel (pack[4]);
        l5.setBounds(50, 210, 300, 30);
        l5.setForeground(new Color(120, 71, 204));
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);
        
        JLabel l6 = new JLabel (pack[5]);
        l6.setBounds(50, 260, 300, 30);
        l6.setForeground(new Color(71, 204, 202));
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);
        
        JLabel l7 = new JLabel (pack[6]);
        l7.setBounds(50, 310, 300, 30);
        l7.setForeground(new Color(120, 71, 204));
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);
        
        JLabel l8 = new JLabel (pack[7]);
        l8.setBounds(50, 360, 300, 30);
        l8.setForeground(new Color(71, 204, 202));
        l8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l8);
        
        JButton l9 = new JButton (pack[8]);
        l9.setBounds(350, 450, 200, 30);
        l9.setForeground(new Color(235, 47, 100));
        l9.setFont(new Font("Tahoma", Font.BOLD, 20));
        l9.addActionListener(this);
        p1.add(l9);
        
        JLabel l10 = new JLabel (pack[9]);
        l10.setBounds(340, 490, 300, 30);
        l10.setForeground(new Color(47, 235, 185));
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l10);
        
        JLabel l11 = new JLabel (pack[10]);
        l11.setBounds(700, 3, 300, 30);
        l11.setForeground(new Color(36, 240, 236));
        l11.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 450, 420);
        p1.add(image);
        
        return p1;
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new BookPackage(""); 
    }
     public static void main (String[] args) {
        new CheckPackage();
    }
}
