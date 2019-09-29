package Controller;

import Run.MenuUtama;
import View.AddEmoneyView;
import Model.LoginModel;
import Model.AddEmoneyModel;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddEmoneyController {

    private AddEmoneyModel eMoneyModel;
    private AddEmoneyView eMoneyView;
    LoginModel loginModel;
//    private String DBurl = "jdbc:mysql://localhost/bioskop";
//    private String DBusername = "root";
//    private String DBpassword = "system";
    Connection koneksi;
    Statement statement;
    ResultSet result;

    public AddEmoneyController(AddEmoneyView eMoneyView, AddEmoneyModel eMoneyModel, LoginModel loginModel) {
        this.eMoneyView = eMoneyView;
        this.eMoneyModel = eMoneyModel;
        this.loginModel = loginModel;
        
        this.eMoneyModel.GeteMoney();
        this.eMoneyView.seteMoneyNow(eMoneyModel.geteMoneyNow());
        
        this.eMoneyView.addNewEmoneyListener(new AddButtonListener());
        this.eMoneyView.backAddListener(new backButtonListener());
    }

    public class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eMoneyModel.setNeweMoney();
            eMoneyView.setKosong();
            eMoneyView.seteMoneyNow(eMoneyModel.geteMoneyAfterUpdated());
        }
    }

    public class backButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eMoneyModel.close();
            eMoneyView.dispose();
            new MenuUtama(loginModel);
        }

    }
//    public static void main(String[] args) {
//        new MenuUtama();
//    }
}
