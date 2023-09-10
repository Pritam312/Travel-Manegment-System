package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    JLabel text,lblusername,lblpackage, lblphone, lblid, lblnumber,lblpersons, lbltotal;
    JLabel labelusername, labelprice, labelnumber, labelid, labelphone;
    JTextField tfpersons;
    JButton checkprice, bookpackage, back;
    Choice cpackage;
    String username;
    
    BookPackage(String username){
        this.username = username;
        setBounds(250, 50, 1000, 580);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    
        text = new JLabel("BOOK PACKAGE");
        text.setBounds(450, 5, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
    
        lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 150, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 150, 20);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);

        lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40, 120, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 120, 150, 25);
        add(cpackage);    

        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 170, 200, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 170, 150, 25);
        add(tfpersons);

        lblid = new JLabel("Id");
        lblid.setBounds(40, 220, 200, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 220, 150, 25);
        add(labelid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 270, 200, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 270, 150, 25);
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 320, 200, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 320, 150, 25);
        add(labelphone);

        lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 370, 200, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 370, 150, 25);
        add(labelprice);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 450, 130, 25);
        checkprice.setBackground(new Color(102, 181, 232));
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(230, 450, 146, 25);
        bookpackage.setBackground(new Color(102, 181, 232));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(415, 450, 130, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 30, 450, 420);
        add(image);
        


     setVisible(true);
    }
    
    
   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 20000;  
            } else if (pack.equals("Silver Package")){
                cost += 15000; 
            } else {
                cost += 10000; 
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs " + cost);
            
        }else if (ae.getSource() == bookpackage) {
            try {
            Conn c = new Conn();
            String query = "insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"','"+labelprice.getText()+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Package Booked Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new BookPackage("");
    }
}
