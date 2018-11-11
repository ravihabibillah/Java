package theConnection;

import TheModel.ModelForm;
import TheView.ViewTabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Koneksi extends JFrame {

    ModelForm theForm[];
    ViewTabel theView;
    private String DBurl = "jdbc:mysql://localhost/latres_pbo_a";
    private String DBusername = "root";
    private String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet result;

    public Koneksi(ModelForm form[], ViewTabel view) {
        this.theForm = form;
        this.theView = view;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak Ditemukan!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak Ditemukan!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Create(ModelForm form) {
        try {
            statement.executeUpdate("INSERT INTO datamahasiswa VALUES ('" + form.getNim() + "','" + form.getNama() + "','" + form.getKelas() + "','" + form.getSemester() + "','" + form.getSks() + "')");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ReadData() {
        try {
            result = statement.executeQuery("SELECT * FROM datamahasiswa");
            int i = 0;
            while (result.next()) {
                theForm[i] = new ModelForm();

                theForm[i].setNim(result.getString("NIM"));
                theForm[i].setNama(result.getString("Nama"));
                theForm[i].setKelas(result.getString("Kelas"));
                theForm[i].setSemester(result.getString("Semester"));
                theForm[i].setSks(result.getInt("Sks"));
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiRead!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HapusOnClick() {
        try {
            statement.executeUpdate("DELETE FROM datamahasiswa WHERE Nama = '" + theView.getHapus() + "' or NIM='" + theView.getHapus() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus!!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiHapus!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateData(int row, String nim, String nama, String kelas, String semester, int sks) {
        try {
            statement.executeUpdate("UPDATE datamahasiswa SET NIM ='" + nim + "' WHERE Nama ='" + theForm[row].getNama() + "'");
            statement.executeUpdate("UPDATE datamahasiswa SET Nama ='" + nama + "' WHERE NIM ='" + theForm[row].getNim() + "'");
            statement.executeUpdate("UPDATE datamahasiswa SET Kelas ='" + kelas + "' WHERE NIM ='" + theForm[row].getNim() + "'");
            statement.executeUpdate("UPDATE datamahasiswa SET Semester ='" + semester + "' WHERE NIM ='" + theForm[row].getNim() + "'");
            statement.executeUpdate("UPDATE datamahasiswa SET Sks ='" + sks + "' WHERE NIM ='" + theForm[row].getNim() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate!!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate!!", "Failed", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close() {
        try {
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
