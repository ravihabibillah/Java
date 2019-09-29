package Model;

import Run.MenuUtama;
import View.LoginView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginModel {

    LoginView theView;
    private String Username, Password, ID;
    private boolean check = false;

    private String DBurl = "jdbc:mysql://localhost/bioskop";
    private String DBusername = "root";
    private String DBpassword = "system";
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
    
    public void setID(String ID){
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    
    public String getID(){
        return ID;
    }

    public boolean checkUserAndPass() {     //--> untuk mengecheck apakah ada tau tidaknya user dan password di database
        if ((theView.getUserField().equals(getUsername())) && (theView.getPassField().equals(getPassword()))) {
            return check = true;    // jika ada
        } else {
            return check = false;   // jika tidak ada
        }
    }

    public void getDatabase() {     //mengambil data yang ada di database kemudian di check;
        ResultSet RS;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            RS = statement.executeQuery("SELECT * FROM pembeli");
            while (RS.next()) {
                String idAbs = RS.getString("id_pembeli");      //ngambil id dri database
                String userAbs = RS.getString("username");      //ngambil username dri database
                String passAbs = RS.getString("password");      //ngambil password dri database
                
                setID(idAbs);               // nge set id ke model
                setUsername(userAbs);       // nge set username ke model
                setPassword(passAbs);       // nge set password ke model

                if (checkUserAndPass()) {       // di check
                    theView.displayAfter("Login Succesfully");  //menampilkan pop up
                    theView.dispose();                          //dispose tampilan login
                    new MenuUtama(this);                        //kemudian ke menu utama dengan membawa model login
                    break;
                }
            }
            if (checkUserAndPass() == false) {
                theView.displayAfter("Wrong Username or Password");     //menampilkan pop up
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
