/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheView;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class ViewLogin extends JFrame{
    JLabel title = new JLabel("Login");
    JLabel user = new JLabel("Username");
    JLabel pass = new JLabel("Password");

    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    public ViewLogin() {
        setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        add(title);
        add(user);
        add(pass);
        add(userField);
        add(passField);
        add(loginButton);
        
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 20));
        //setbound(x,y,panjang,lebar)
        title.setBounds(200, 10, 100, 30);
        user.setBounds(80, 65, 70, 20);
        pass.setBounds(80, 115, 70, 20);
        userField.setBounds(210, 65, 150, 20);
        passField.setBounds(210, 115, 150, 20);
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

    public void displaySuccess(String theMessage) {
        JOptionPane.showMessageDialog(this, theMessage,"Success",JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayFailed(String theMessage) {
        JOptionPane.showMessageDialog(this, theMessage,"Failed",JOptionPane.ERROR_MESSAGE);
    }
}
