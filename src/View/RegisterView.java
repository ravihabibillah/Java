package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {

    JLabel userLbl = new JLabel("Username : ");
    JLabel passLbl = new JLabel("Password : ");
    JLabel emailLbl = new JLabel("Email : ");
    JLabel alamatLbl = new JLabel("Alamat : ");

    JTextField userTF = new JTextField();
    JPasswordField passTF = new JPasswordField();
    JTextField emailTF = new JTextField();
    JTextField alamatTF = new JTextField();

    JButton confirmBtn = new JButton("Confirm");
    JButton backBtn = new JButton("Back");

    public RegisterView() {
        setLayout(null);
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(455, 370);
        setVisible(true);
        setLocationRelativeTo(null);

        add(userLbl).setBounds(80, 55, 90, 10);
        add(passLbl).setBounds(80, 105, 90, 10);
        add(emailLbl).setBounds(80, 155, 90, 10);
        add(alamatLbl).setBounds(80, 205, 90, 10);
        add(userTF).setBounds(210, 50, 150, 20);
        add(passTF).setBounds(210, 100, 150, 20);
        add(emailTF).setBounds(210, 150, 150, 20);
        add(alamatTF).setBounds(210, 200, 150, 20);
        add(backBtn).setBounds(120, 270, 90, 25);
        add(confirmBtn).setBounds(250, 270, 90, 25);
    }

    public String getUserField() {
        return userTF.getText();
    }

    public String getPassField() {
        return passTF.getText();
    }

    public String getEmailField() {
        return emailTF.getText();
    }

    public String getAlamatField() {
        return alamatTF.getText();
    }

    public void addRegisterListener(ActionListener RegisterButtonListener) {
        confirmBtn.addActionListener(RegisterButtonListener);
    }

    public void addBackListener(ActionListener BackButtonListener) {
        backBtn.addActionListener(BackButtonListener);
    }
}
