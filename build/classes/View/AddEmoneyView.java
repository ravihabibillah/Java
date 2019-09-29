package View;


import Model.LoginModel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddEmoneyView extends JFrame {

    JLabel moneyNow = new JLabel("eMoney Saat ini : Rp. " + 0); 
    JLabel pemberitahuan2 = new JLabel("*Masukkan dalam bentuk angka");
    JLabel moneyLbl = new JLabel("eMoney : ");
    JTextField moneyField = new JTextField();
    LoginModel loginUser;
    JButton addBtn = new JButton("Add");
    JButton cancelBtn = new JButton("Cancel");

    public AddEmoneyView(LoginModel loginUser) {
        setLayout(null);
        setTitle("eMoney");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        this.loginUser = loginUser;
        
        add(moneyNow).setBounds(90, 45, 500, 25);
        moneyNow.setFont(new Font(moneyNow.getFont().getName(),moneyNow.getFont().getStyle(),16));
        add(pemberitahuan2).setBounds(80, 120, 500, 25);
        pemberitahuan2.setFont(new Font(pemberitahuan2.getFont().getName(),pemberitahuan2.getFont().getStyle(),10));
        add(moneyLbl).setBounds(75,103,140,20);
        add(moneyField).setBounds(190, 105, 150, 20);
        add(addBtn).setBounds(230, 180, 80, 25);
        add(cancelBtn).setBounds(100, 180, 80, 25);
    }
    
    public String getNewEmoney(){
        return moneyField.getText();
    }
    
    public String getKonfirmasi(){
        return loginUser.getUsername();
    }
    
    public void addNewEmoneyListener(ActionListener AddButtonListener){
        addBtn.addActionListener(AddButtonListener);
    }
    
    public void cancelAddListener(ActionListener CancelButtonListener){
        cancelBtn.addActionListener(CancelButtonListener);
    }
    
    public void setKosong(){
        moneyField.setText("");
    }
    
    public void seteMoneyNow(double eMoney){
        moneyNow.setText("eMoney Saat ini : Rp. " + eMoney);
    }
    
    public void displayMessage(){
        JOptionPane.showMessageDialog(null, "Silahkan Masukkan Angka Nominal", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
    }
}
