package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    JLabel text,lbldays,lblfood,lblusername,lblpackage, lblphone, lblid, lblnumber,lblpersons, lbltotal;
    JLabel labelusername, labelprice,lblac ,labelnumber, labelid, labelphone;
    JTextField tfpersons,tfdays;
    JButton checkprice, bookpackage, back;
    Choice chotel, cac, cfood;
    String username;
    
    BookHotel(String username){
        this.username = username;
        setBounds(250, 15, 1000, 670);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    
        text = new JLabel("BOOK HOTEL");
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

        lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 120, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 120, 150, 20);
        add(chotel);   
        
        try {
             Conn c = new Conn(); 
              ResultSet rs = c.s.executeQuery("select * from hotel");
              while(rs.next()){
                  chotel.add(rs.getString("name"));
              }
        }catch (Exception e){
            e.printStackTrace();
        }

        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 170, 200, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 170, 150, 25);
        add(tfpersons);
        
        lbldays = new JLabel("No. Of Days");
        lbldays.setBounds(40, 220, 200, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 220, 150, 25);
        add(tfdays);

        lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40, 270, 200, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 270, 150, 20);
        add(cac);
        
        lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 320, 200, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 320, 150, 20);
        add(cfood);
        
        lblid = new JLabel("Id");
        lblid.setBounds(40, 370, 200, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 370, 150, 25);
        add(labelid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 420, 200, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 420, 150, 25);
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 470, 200, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 470, 150, 25);
        add(labelphone);

        lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 520, 200, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 520, 150, 25);
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
        checkprice.setBounds(80, 575, 130, 25);
        checkprice.setBackground(new Color(102, 181, 232));
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBounds(250, 575, 146, 25);
        bookpackage.setBackground(new Color(102, 181, 232));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(435, 575, 130, 25);
        back.setBackground(new Color(102, 181, 232));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 80, 500, 420);
        add(image);
        


     setVisible(true);
    }
    
    
   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs" + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() == bookpackage) {
            try {
            Conn c = new Conn();
            String query = "insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new BookHotel("");
    }
}


