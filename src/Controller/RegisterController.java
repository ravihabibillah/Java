package Controller;


import View.RegisterView;
import View.LoginView;
import Model.LoginModel;
import Model.RegisterModel;
import Run.MenuAwal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class RegisterController {

    private RegisterView theView;
    private RegisterModel theModel;
    

    public RegisterController(RegisterView theView, RegisterModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addRegisterListener(new RegisterButtonListener()); //nambahin action ke Tombol Register
        this.theView.addBackListener(new BackButtonListener());         //nambahin action ke Tombol Back
    }

    class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theModel.Regis(theView);    //melakukan method regis yaitu insert data ke database
        }

    }

    class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.setVisible(false); //cuman dibuat invisible ketika menekan tombol back, tidak di dispose
            new MenuAwal();
        }

    }
}
