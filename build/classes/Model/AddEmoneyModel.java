package Model;

import Controller.AddEmoneyController;
import View.AddEmoneyView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddEmoneyModel {

    double eMoneyNew, eMoneyOld;
    AddEmoneyView eMoneyView;
    private String DBurl = "jdbc:mysql://localhost/databioskop";
    private String DBusername = "root";
    private String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet result;

    public AddEmoneyModel(AddEmoneyView eMoneyView) {
        try {
            this.eMoneyView = eMoneyView;

            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmoneyModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmoneyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNeweMoney() {
        try {
            eMoneyNew = Double.parseDouble(eMoneyView.getNewEmoney());
            eMoneyNew = eMoneyNew + eMoneyOld;
            UpdateeMoney();
        } catch (NumberFormatException ae) {
            eMoneyView.displayMessage();
        }
    }

    public void close() {
        try {
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmoneyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GeteMoney() {
        try {
            result = statement.executeQuery("SELECT * FROM data WHERE Nama='" + eMoneyView.getKonfirmasi() + "'");
            while (result.next()) {
                eMoneyOld = result.getDouble("eMoney");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "eMoney Gagal di Get!", "Failed", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(AddEmoneyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateeMoney() {
        try {
            statement.executeUpdate("UPDATE data SET eMoney='" + eMoneyNew + "' WHERE Nama='" + eMoneyView.getKonfirmasi() + "'");
            JOptionPane.showMessageDialog(null, "eMoney Updated!", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmoneyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Double geteMoneyNow(){
        return eMoneyOld;
    }
    
    public Double geteMoneyAfterUpdated(){
        return eMoneyNew;
    }
}
