package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Firstpage extends JFrame implements ActionListener {

    JButton button, checkpackage, viewhotels, destinations,about;
    Firstpage() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1600, 65);
        p1.setBackground(new Color(0, 0, 120));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 300, 900);
        p2.setBackground(new Color(0, 0, 120));
        add(p2);
        
        button = new JButton("Login/Signup");
        button.setBounds(1000, 25, 150, 25);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.addActionListener(this);
        p1.add(button);
        
        checkpackage = new JButton("Check Package");
        checkpackage.setBounds(0, 0, 300, 58);
        checkpackage.setBackground(new Color(0, 0, 102));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.setFont(new Font("Tahoma", Font.BOLD, 20));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 60, 300, 58);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.BOLD, 20));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 120, 300, 58);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.BOLD, 20));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        about = new JButton("About");
        about.setBounds(0, 180, 300, 58);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.BOLD, 20));
        about.addActionListener(this);
        p2.add(about);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);
        
        JLabel text = new JLabel("Ghosh Travel and Tourism");
        text.setBounds(500, 70, 1000, 70);
        text.setForeground(new Color(252, 182, 3));
        text.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkpackage) {
            new CheckPackage();
        }else if (ae.getSource() == viewhotels) {
            new CheckHotels();
        }else if (ae.getSource() == destinations) {
            new Destinations();
        }else if (ae.getSource() == about){
            new About();
        }else if (ae.getSource() == button){
            setVisible(false);
            new Login();
        }
    
    } 

    public static void main (String[] args) {
       new Firstpage();
       
}
}

