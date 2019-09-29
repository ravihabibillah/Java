package Run;

import Controller.SeeTheFilmController;
import Controller.LoginController;
import Controller.AddEmoneyController;
import View.LoginView;
import View.AddEmoneyView;
import View.SeeTheFilmView;
import Model.AddEmoneyModel;
import Model.DataFilmModel;
import Model.LoginModel;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MenuUtama extends JFrame {

    MenuUtama utama = this;
    SeeTheFilmView list;
    JLabel topLabel = new JLabel();
    JButton menuAddEmoney = new JButton("Add eMoney");
    JButton back = new JButton("Back to Login");
    JButton seeFilm = new JButton("List Film");
    LoginModel loginModel;
    boolean check = false;

    public MenuUtama(LoginModel loginModel) {
        setLayout(null);
        setTitle("Menu Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(255, 270);
        setVisible(true);
        setLocationRelativeTo(null);
        this.loginModel = loginModel;
        add(topLabel).setBounds(45, 20, 170, 25);
        add(seeFilm).setBounds(60, 70, 120, 25);
        add(menuAddEmoney).setBounds(60, 120, 120, 25);
        add(back).setBounds(60, 170, 120, 25);
        topLabel.setText("Selamat Datang " + loginModel.getUsername() + " !");
        topLabel.setFont(new Font("Calibri", Font.BOLD, 16));

        seeFilm.addActionListener(new GoToList());
        menuAddEmoney.addActionListener(new GoToAddEmoney());
        back.addActionListener(new GoToMenuLogin());

    }

    class GoToList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (check == false) {
                setLocation(50, 100);
                DataFilmModel theModel[] = new DataFilmModel[10];
                SeeTheFilmView theView = new SeeTheFilmView(theModel);
                SeeTheFilmController theController = new SeeTheFilmController(theView, theModel, loginModel, utama);
                list = theView;
                list.appear();
                check = true;
            } else {
                list.destroy();
                setLocation(50, 100);
                DataFilmModel theModel[] = new DataFilmModel[10];
                SeeTheFilmView theView = new SeeTheFilmView(theModel);
                SeeTheFilmController theController = new SeeTheFilmController(theView, theModel, loginModel, utama);
                list = theView;
                list.appear();
            }
        }

    }

    class GoToAddEmoney implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (check) {
                list.destroy();
            }
            dispose();
            AddEmoneyView theView = new AddEmoneyView(loginModel);
            AddEmoneyModel theModel = new AddEmoneyModel(theView);
            AddEmoneyController thecontroller = new AddEmoneyController(theView, theModel, loginModel);
        }
    }

    class GoToMenuLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            if (check) {
                list.destroy();
            }
            LoginView theView = new LoginView();
            LoginModel theModel = new LoginModel(theView);
            LoginController thecontroller = new LoginController(theView, theModel);
        }

    }

    public void appear() {
        setVisible(true);
    }

    public void invisible() {
        setVisible(false);
    }
}
