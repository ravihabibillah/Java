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
        setSize(215, 180);
        setVisible(true);
        setLocationRelativeTo(null);

        add(menuLogin).setBounds(60, 30, 80, 25);
        add(menuRegister).setBounds(50, 80, 100, 25);

        menuLogin.addActionListener(new GoToLoginListener());
        menuRegister.addActionListener(new GoToRegisterListener());
    }

    class GoToLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();

            LoginView theView = new LoginView();
            LoginModel theModel = new LoginModel(theView);
            LoginController theController = new LoginController(theView, theModel);
        }
    }

    class GoToRegisterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();

            RegisterView theView = new RegisterView();
            RegisterModel theModel = new RegisterModel();
            RegisterController theController = new RegisterController(theView, theModel);
        }

    }

    public static void main(String[] args) {
        new MenuAwal();
    }
}
