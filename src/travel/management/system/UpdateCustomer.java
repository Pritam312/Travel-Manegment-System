package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel text, lblusername,labelusername, lbladdress, lblemail,lblpassword, lblphone, lblgender,lblcountry,lblid, lblnumber,lblname, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid, tfgender, tfpassword;
    JRadioButton rmale, rfemale;
    JButton add, back;
    
    
    UpdateCustomer(String username) {
       
        setBounds(300, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        text = new JLabel("UPDATE PERSONAL DETAILS");
        text.setBounds(300, 2, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        lblusername = new JLabel ("Username");
        lblusername.setBounds(30, 50, 200, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);
        
        labelusername = new JLabel ();
        labelusername.setBounds(220, 50, 200, 25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);
        
        lblid = new JLabel ("Id");
        lblid.setBounds(30, 90, 199, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(220, 90, 200, 25);
        add(tfid);
        
        lblnumber = new JLabel ("Number");
        lblnumber.setBounds(30, 130, 200, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 200, 25);
        add(tfnumber);
        
        lblname = new JLabel ("Name");
        lblname.setBounds(30, 170, 200, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblname);
        
        labelname = new JLabel ();
        labelname.setBounds(220, 170, 200, 25);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelname);
        
        lblgender = new JLabel ("Gender");
        lblgender.setBounds(30, 210, 200, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 200, 25);
        add(tfgender);
        
        lblcountry = new JLabel ("Country");
        lblcountry.setBounds(30, 250, 200, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 200, 25);
        add(tfcountry);
        
        lbladdress = new JLabel ("Address");
        lbladdress.setBounds(30, 290, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 200, 25);
        add(tfaddress);
        
        lblphone = new JLabel ("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 200, 25);
        add(tfphone);
        
        lblemail = new JLabel ("Email");
        lblemail.setBounds(30, 370, 200, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 200, 25);
        add(tfemail);
        
        lblpassword = new JLabel ("Password");
        lblpassword.setBounds(30, 410, 200, 25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 410, 200, 25);
        add(tfpassword);
        
        add = new JButton("Update");
        add.setBounds(60, 470, 100, 25);
        add.setBackground(new Color(102, 181, 232));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(260, 470, 100, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 450, 420);
        add(image);
        
        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
  
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String password = tfpassword.getText();
            try {
                Conn c = new Conn();
                String query1 = "update account set password = '"+password+"' ";
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"' ";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Customer Details Update Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new UpdateCustomer("Pritam");
    }
    
}

