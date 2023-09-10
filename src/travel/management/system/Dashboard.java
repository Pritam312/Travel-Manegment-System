package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton addpersonalDetails, updatepersonalDetails, viewpersonalDetails, deletepersonalDetails, checkpackage,bookpackage;
    JButton viewpackage, viewhotels, bookhotel, viewBookedHotel, destinations, payments,about,logout;
    String username;
    
    Dashboard(String username) {
        this.username = username;

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
        
        addpersonalDetails = new JButton("Add Personal Details");
        addpersonalDetails.setBounds(0, 0, 300, 40);
        addpersonalDetails.setBackground(new Color(0, 0, 102));
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        addpersonalDetails.addActionListener(this);
        p2.add(addpersonalDetails);
        
        updatepersonalDetails = new JButton("Update Personal Details");
        updatepersonalDetails.setBounds(0, 41, 300, 40);
        updatepersonalDetails.setBackground(new Color(0, 0, 102));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);
        
        viewpersonalDetails = new JButton("View Details");
        viewpersonalDetails.setBounds(0, 82, 300, 40);
        viewpersonalDetails.setBackground(new Color(0, 0, 102));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);
        
        deletepersonalDetails = new JButton("Delete Personal Details");
        deletepersonalDetails.setBounds(0, 123, 300, 40);
        deletepersonalDetails.setBackground(new Color(0, 0, 102));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        deletepersonalDetails.addActionListener(this);
        p2.add(deletepersonalDetails);
        
        checkpackage = new JButton("Check Package");
        checkpackage.setBounds(0, 164, 300, 40);
        checkpackage.setBackground(new Color(0, 0, 102));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 205, 300, 40);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0, 246, 300, 40);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 287, 300, 40);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.BOLD, 14));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 328, 300, 40);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 369, 300, 40);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 410, 300, 40);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.BOLD, 14));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0, 451, 300, 40);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.BOLD, 14));
        payments.addActionListener(this);
        p2.add(payments);
        
        
        about = new JButton("About");
        about.setBounds(0, 492, 300, 40);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.BOLD, 14));
        about.addActionListener(this);
        p2.add(about);
        
        logout = new JButton("Log Out");
        logout.setBounds(0, 533, 300, 40);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 14));
        logout.addActionListener(this);
        p2.add(logout);
        
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
        if (ae.getSource() == addpersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewpersonalDetails) {
            new ViewCustomer(username);
        }else if (ae.getSource() == updatepersonalDetails) {
            new UpdateCustomer(username);
        }else if (ae.getSource() == checkpackage) {
            new CheckPackage();
        }else if (ae.getSource() == bookpackage) {
            new BookPackage(username);
        }else if (ae.getSource() == viewpackage) {
            new ViewPackage(username);
        }else if (ae.getSource() == viewhotels) {
            new CheckHotels();
        }else if (ae.getSource() == destinations) {
            new Destinations();
        }else if (ae.getSource() == bookhotel) {
            new BookHotel(username);
        }else if (ae.getSource() == viewBookedHotel) {
            new ViewBookedHotel(username);
        }else if (ae.getSource() == payments) {
            new Payment();
        }
        else if (ae.getSource() == about){
            new About();
        } else if (ae.getSource() == logout){
            System.exit(0);
        }else if (ae.getSource() == deletepersonalDetails){
            new DeleteDetails("");
        }
    
    }  
    
    public static void main (String[] args) {
        new Dashboard("");
    }
}
