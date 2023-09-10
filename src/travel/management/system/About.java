package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
   
    About(){
        setBounds(400, 100, 500, 600);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(210, 10, 100, 50);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        
        String s = "About Projects:- \n"+
                "\n"+
                "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activities of a travel and the purpose is to design a system using which one can perform all operations related to traveling. \n"+
                "\n"+
                "This application will help in accessing the information related to the travel to the particular destination with great ease. The users can track the information related to their tours by this application. The travel agency information can also be obtained through this application. \n"+
                "\n"+
                "Advantages of Project:- Gives accurate information. \n"+  
                "Simplifies the manual work \n"+ 
                "It minimizes the documentation related work\n"+ 
                "Provides up to date information\n"+ 
                "Friendly Environment by providing warning messages. \n"+ 
                "travelers details can be provided\n"+ 
                "booking confirmation notification";
     
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 70, 450, 350);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 460, 80, 40);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        setVisible(true);
    }
    
   
     public void actionPerformed(ActionEvent ae) {
         setVisible(false);
    }
    public static void main (String[] args) {
        new About();
    }
}
