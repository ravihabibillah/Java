package Run;


import Controller.LoginController;
import Controller.RegisterController;
import View.LoginView;
import View.RegisterView;
import Model.LoginModel;
import Model.RegisterModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAwal extends JFrame {

    JButton menuLogin = new JButton("Login");
    JButton menuRegister = new JButton("Register");

    public MenuAwal() {
        setLayout(null);
        setTitle("Awal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 180);
        setVisible(true);
        setLocationRelativeTo(null);

        add(menuLogin).setBounds(60, 30, 80, 25);
        add(menuRegister).setBounds(50, 80, 100, 25);

        menuLogin.addActionListener(new GoToLoginListener());           //memberi action untuk login ke tombol login
        menuRegister.addActionListener(new GoToRegisterListener());     //memberi action untuk register ke tombol register
    }

    class GoToLoginListener implements ActionListener { //memilih login

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();      //men dispose tampilan menu awal ini

            LoginView theView = new LoginView();       //memanggil tampilan login
            LoginModel theModel = new LoginModel(theView);  //memanggil model login
            LoginController theController = new LoginController(theView, theModel); //memanggil kontroler login
        }
    }

    class GoToRegisterListener implements ActionListener {  //memilih register

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();      //men dispose tampilan menu awal ini

            RegisterView theView = new RegisterView();      //memanggil tampilan register
            RegisterModel theModel = new RegisterModel();       //memanggil model register
            RegisterController theController = new RegisterController(theView, theModel);       //memanggil kontroller register
        }

    }

    public static void main(String[] args) {
        new MenuAwal();     //untuk run menuAwal
    }
}
