package Run;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class InputDataClass extends JFrame {

    JLabel background = new JLabel();
    JLabel titleLabel = new JLabel("Input Film");
    JLabel tahunLabel = new JLabel("Tahun Rilis : ");
    JLabel judulLabel = new JLabel("Judul Film : ");
    JLabel hargaLabel = new JLabel("Harga Tiket : ");
    JLabel sinopsisLabel = new JLabel("Sinopsis Film : ");
    JLabel jamLabel = new JLabel("Waktu : ");

    JTextField tahunField = new JTextField(4);
    JTextField judulField = new JTextField(20);
    JTextField hargaField = new JTextField(10);
    JTextArea sinopsisArea = new JTextArea();
    JTextField jamField = new JTextField(10);

    JButton saveButton = new JButton("Simpan");
    JButton deleteButton = new JButton("Hapus");
    JButton resetButton = new JButton("Reset");

    JScrollPane scroll = new JScrollPane(sinopsisArea);

    private String DBurl = "jdbc:mysql://localhost/datafilm";
    private String DBusername = "root";
    private String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public InputDataClass() {
        setLayout(null);
        setTitle("Setting the Film Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(470, 550);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        add(titleLabel).setBounds(180, 20, 500, 25);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), titleLabel.getFont().getStyle(), 20));
        add(tahunLabel).setBounds(60, 80, 100, 20);
        add(judulLabel).setBounds(60, 130, 100, 20);
        add(hargaLabel).setBounds(60, 180, 100, 20);
        add(sinopsisLabel).setBounds(60, 235, 100, 10);
        add(jamLabel).setBounds(60, 400, 100, 10);

        add(tahunField).setBounds(200, 80, 180, 20);
        add(judulField).setBounds(200, 130, 180, 20);
        add(hargaField).setBounds(200, 180, 180, 20);
        add(scroll).setBounds(200, 230, 180, 140);
        sinopsisArea.setLineWrap(true);
        add(jamField).setBounds(200, 395, 180, 20);

        add(deleteButton).setBounds(185, 445, 80, 25);
        add(saveButton).setBounds(285, 445, 80, 25);
        add(resetButton).setBounds(85, 445, 80, 25);
//        
//        background.setIcon(new ImageIcon("E:\\Java\\ProjectPBO\\src\\Image\\2.jpg"));
//        add(background).setBounds(0, 0, 400, 550);

        saveButton.addActionListener(new SaveButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

    }

    public class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
                statement = koneksi.createStatement();
                statement.executeUpdate("INSERT INTO data values ('" + tahunField.getText() + "','" + judulField.getText() + "','" + hargaField.getText() + "','" + sinopsisArea.getText() + "','" + jamField.getText() + "')");
                JOptionPane.showMessageDialog(null, "Film Sudah Terdaftar!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                statement.close();
                koneksi.close();
                Kosong();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Film Gagal Didaftarkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Salah Input Pada Tahun Rilis / Harga!", "Hasil", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
                statement = koneksi.createStatement();
                statement.executeUpdate("DELETE FROM data WHERE Judul='" + judulField.getText() + "'");
                JOptionPane.showMessageDialog(null, "Film sudah Terhapus!!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                statement.close();
                koneksi.close();
                Kosong();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InputDataClass.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Film gagal Dihapus!!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(InputDataClass.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Kosong();
        }

    }

    public void Kosong() {
        judulField.setText("");
        tahunField.setText("");
        hargaField.setText("");
        sinopsisArea.setText("");
        jamField.setText("");
    }

    public static void main(String[] args) {
        new InputDataClass();
    }
}
