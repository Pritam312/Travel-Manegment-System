package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel lblusername,labelusername, lbladdress, lblemail, lblphone, lblgender,lblcountry,lblid, lblnumber,lblname, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    
    
    AddCustomer(String username) {
       
        setBounds(300, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
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
        
        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "RationCard"});
        comboid.setBounds(220, 90, 200, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 100, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(350, 210, 100, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add");
        add.setBounds(40, 450, 100, 25);
        add.setBackground(new Color(102, 181, 232));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(240, 450, 100, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 450, 420);
        add(image);
        
        try {
            Conn c = new Conn();
            String query = "select * from account where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
  
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"','"+number+"', '"+name+"', '"+gender+"','"+country+"', '"+address+"', '"+phone+"', '"+email+"' )";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Dashboard("");
        } else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new AddCustomer("");
    }
    
}
