package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener {
    
    JLabel lblusername, lbladdress, lblemail, lblphone, lblgender,lblcountry,lblid, lblnumber,lblname ;
    JLabel labelusername, labelname, labelnumber, labelid, labelgender, labelcountry, labelemail, labelphone, labeladdress ;
    JButton back , delete;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(300, 80, 850, 625);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        lblusername = new JLabel ("Username: ");
        lblusername.setBounds(30, 50, 200, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);
        
        labelusername = new JLabel ();
        labelusername.setBounds(220, 50, 200, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelusername);
        
        lblid = new JLabel ("Id:");
        lblid.setBounds(30, 110, 200, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);
        
        labelid = new JLabel ();
        labelid .setBounds(220, 110, 200, 25);
        labelid .setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelid );
        
        lblnumber = new JLabel ("Number:");
        lblnumber.setBounds(30, 170, 200, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 200, 25);
        add(labelnumber);
        
        lblname = new JLabel ("Name:");
        lblname.setBounds(30, 230, 200, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 230, 200, 25);
        add(labelname);
        
        lblgender = new JLabel ("Gender:");
        lblgender.setBounds(30, 290, 200, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 290, 200, 25);
        add(labelgender);
        
        lblcountry = new JLabel ("Country:");
        lblcountry.setBounds(500, 50, 200, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(700, 50, 200, 25);
        add(labelcountry);
        
        lbladdress = new JLabel ("Address:");
        lbladdress.setBounds(500, 110, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(700, 110, 200, 25);
        add(labeladdress);
        
        lblphone = new JLabel ("Phone:");
        lblphone.setBounds(500, 170, 200, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(700, 170, 200, 25);
        add(labelphone);
        
        lblemail = new JLabel ("Email:");
        lblemail.setBounds(500, 230, 200, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(700, 230, 200, 25);
        add(labelemail);
   
        back = new JButton("Back");
        back.setBounds(250, 350, 100, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        delete = new JButton("Delete?");
        delete.setBounds(450, 350, 100, 25);
        delete.setBackground(new Color(102, 181, 232));
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '"+username+"'");
                c.s.executeUpdate("delete from customer where username = '"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
                JOptionPane.showMessageDialog(null, "Data Delete Successfully");
                setVisible(false);
                new Firstpage();
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
     public static void main (String[] args) {
        new DeleteDetails("Pritam");
    }
}
