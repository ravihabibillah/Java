package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    JLabel title = new JLabel("Login");
    JLabel user = new JLabel("Username  :");
    JLabel pass = new JLabel("Password  :");

    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Back");

    public LoginView() {
        setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(470, 300);
        setVisible(true);
        setLocationRelativeTo(null);

        add(title);
        add(user);
        add(pass);
        add(userField);
        add(passField);
        add(loginButton);
        add(backButton);
        
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 20));
        //setbound(x,y,panjang,lebar)
        title.setBounds(200, 10, 100, 30);
        user.setBounds(80, 65, 70, 20);
        pass.setBounds(80, 115, 70, 20);
        userField.setBounds(210, 65, 150, 20);
        passField.setBounds(210, 115, 150, 20);
        backButton.setBounds(120, 180, 80, 25);
        loginButton.setBounds(250, 180, 80, 25);
    }

    public String getUserField() {
        return userField.getText();
    }

    public String getPassField() {
        return passField.getText();
    }

    public void addLoginListener(ActionListener LoginButtonListener) {
        loginButton.addActionListener(LoginButtonListener);
    }

    public void addBackListener(ActionListener BackButtonListener) {
        backButton.addActionListener(BackButtonListener);
    }

    public void displayAfter(String theMessage) {
        JOptionPane.showMessageDialog(this, theMessage);
    }
}
