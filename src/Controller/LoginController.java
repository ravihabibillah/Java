package Controller;

import Run.MenuUtama;
import View.LoginView;
import Model.LoginModel;
import Run.MenuAwal;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class LoginController {

    private LoginView theView;
    private LoginModel theModel;


    public LoginController(LoginView theView, LoginModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addLoginListener(new LoginButtonListener());       //memberi action untuk tombol login
        this.theView.addBackListener(new BackButtonListener());         //memberi action untuk tombol back
    }

    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theModel.getDatabase(); //memanggil getDatabase yang ada di model Login
        }
    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.setVisible(false);
            new MenuAwal(); //memanggil menu awal kembali
        }

    }
}
