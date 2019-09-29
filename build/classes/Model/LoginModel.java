package Model;

import Run.MenuUtama;
import View.LoginView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginModel {

    LoginView theView;
    private String Username, Password;
    private boolean check = false;

    private String DBurl = "jdbc:mysql://localhost/databioskop";
    private String DBusername = "root";
    private String DBpassword = "";
    Connection koneksi;
    Statement statement;

    LoginModel() {

    }

    public LoginModel(LoginView theView) {
        this.theView = theView;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public boolean checkUserAndPass() {
        if ((theView.getUserField().equals(getUsername())) && (theView.getPassField().equals(getPassword()))) {
            return check = true;
        } else {
            return check = false;
        }
    }

    public void getDatabase() {
        ResultSet RS;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            RS = statement.executeQuery("SELECT * FROM data");
            while (RS.next()) {
                String userAbs = RS.getString("Nama");
                String passAbs = RS.getString("Password");
                setUsername(userAbs);
                setPassword(passAbs);

                if (checkUserAndPass()) {
                    theView.displayAfter("Login Succesfully");
                    theView.dispose();
                    new MenuUtama(this);
                    break;
                }
            }
            if (checkUserAndPass() == false) {
                theView.displayAfter("Wrong Username or Password");
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Tidak Bisa Login", "SQL ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!!!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

}
