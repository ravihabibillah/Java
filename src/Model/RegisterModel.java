package Model;

import Controller.LoginController;
import View.LoginView;
import View.RegisterView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class RegisterModel extends LoginModel {

    private String email, alamat;
    double eMoney;

    private String DBurl = "jdbc:mysql://localhost/bioskop";
    private String DBusername = "root";
    private String DBpassword = "system";
    Connection koneksi;
    Statement statement;
    
    public RegisterModel() {
        eMoney = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double geteMoney() {
        return eMoney;
    }

    public void seteMoney(double eMoney) {
        this.eMoney = eMoney;
    }

    public void Regis(RegisterView theView){    //Insert data ke database tabel Pembeli
        try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
                statement = koneksi.createStatement();
                statement.executeUpdate("INSERT INTO pembeli(username,password,email,alamat,emoney) values ('" + theView.getUserField() + "','" + theView.getPassField() + "','" + theView.getEmailField() + "','" + theView.getAlamatField() + "','" + geteMoney() + "')");
                JOptionPane.showMessageDialog(null, "Account has Registered!", "Hasil", JOptionPane.INFORMATION_MESSAGE); // jika akun berhasil didaftarkan
                statement.close();
                koneksi.close();
                theView.dispose();
                LoginView goView = new LoginView();                                 //membuat tampilan login
                LoginModel goModel = new LoginModel(goView);                        //membuat model login
                LoginController goControl = new LoginController(goView,goModel);    //membuat kontroler login

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed to Registered an Account!", "Hasil", JOptionPane.ERROR_MESSAGE); // pesan error jika gagal didaftarkan
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!!!", "Hasil", JOptionPane.ERROR_MESSAGE); // pesan error jika sql error
            }
    }
}