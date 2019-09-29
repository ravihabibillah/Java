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

        this.theView.addLoginListener(new LoginButtonListener());
        this.theView.addBackListener(new BackButtonListener());
    }

    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theModel.getDatabase();
        }
    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.setVisible(false);
            new MenuAwal();
        }

    }
}
