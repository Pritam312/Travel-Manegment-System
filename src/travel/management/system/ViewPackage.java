package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener{
    JLabel text, lblusername, lbladdress, lblgender, lblcountry, lblid, lblnumber, lblname;
    JLabel labelusername, labelnumber, labelpersons, labelpackage, labelprice, labelid, labelphone;
    JButton back;
    String username;
    
    ViewPackage(String username){
        this.username = username;
        setBounds(300, 50, 900, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    
        text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(90, 5, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(text);
    
        lblusername = new JLabel ("Username");
        lblusername.setBounds(30, 60, 200, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);
        
        labelusername = new JLabel ();
        labelusername.setBounds(220, 60, 200, 25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);
        
        lblid = new JLabel ("Package");
        lblid.setBounds(30, 110, 200, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);
        
        labelpackage= new JLabel ();
        labelpackage .setBounds(220, 110, 200, 25);
        labelpackage .setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelpackage );
        
        lblnumber = new JLabel ("Total Persons");
        lblnumber.setBounds(30, 160, 200, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);
        
        labelpersons = new JLabel();
        labelpersons.setBounds(220, 160, 200, 25);
        add(labelpersons);
        
        lblname = new JLabel ("Id");
        lblname.setBounds(30, 210, 200, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblname);
        
        labelid = new JLabel();
        labelid.setBounds(220, 210, 200, 25);
        add(labelid);
        
        lblgender = new JLabel ("Number");
        lblgender.setBounds(30, 260, 200, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblgender);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 260, 200, 25);
        add(labelnumber);
        
        lblcountry = new JLabel ("Phone");
        lblcountry.setBounds(30, 310, 200, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcountry);
        
        labelphone = new JLabel();
        labelphone.setBounds(220, 310, 200, 25);
        add(labelphone);
        
        lbladdress = new JLabel ("Price");
        lbladdress.setBounds(30, 360, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbladdress);
        
        labelprice = new JLabel();
        labelprice.setBounds(220, 360, 200, 25);
        add(labelprice);
   
        back = new JButton("Back");
        back.setBounds(150, 450, 100, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 500, 430);
        add(image);
        
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
     public static void main (String[] args) {
        new ViewPackage("");
    }
}
