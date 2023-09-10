package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
   
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    
    ForgetPassword() {
        setBounds(300, 200, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630, 70, 200, 200);
        add(image);
        
        
        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 550, 300 );
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel ("Username");
        lblusername.setBounds(20, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
           
        search = new JButton("Search");
        search.setBounds(420, 20, 100, 25);
        search.setBackground(new Color(102, 181, 232));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma", Font.BOLD, 15));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel ("Name");
        lblname.setBounds(20, 70, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 70, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        JLabel lblquestion = new JLabel ("Your Security Question");
        lblquestion.setBounds(20, 120, 200, 25);
        lblquestion.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(220, 120, 180, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel ("Your Answer");
        lblanswer.setBounds(20, 170, 200, 25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 170, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(420, 170, 100, 25);
        retrieve.setBackground(new Color(102, 181, 232));
        retrieve.setForeground(Color.WHITE);
        retrieve.setFont(new Font("Tahoma", Font.BOLD, 15));
        retrieve.setBorder(BorderFactory.createEmptyBorder());
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel ("Your Password");
        lblpassword.setBounds(20, 220, 200, 25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 220, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBounds(190, 265, 100, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("question"));
                }  
        }catch (Exception e) {
            e.printStackTrace();
        }   
        } else if (ae.getSource() == retrieve) {
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"' ";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                }  
        }catch (Exception e) {
            e.printStackTrace();
        }
        } else {
            setVisible(false);
            new Login();
        }
    }
     public static void main (String[] args) {
        new ForgetPassword();
    }
}
