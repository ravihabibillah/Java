package View;

import Controller.BuyController;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BuyView extends JFrame {

    public JButton[][] seat = new JButton[3][3];
    JButton back = new JButton("Back");
    JButton confirm = new JButton("Confirm");
    JButton screen = new JButton("Screen");

    JPanel besidePanel = new JPanel();

    JLabel judul = new JLabel();
    JLabel jam = new JLabel();
    JLabel theSeat = new JLabel("Seats      : ");
    JLabel jumlah = new JLabel("0");
    JLabel theTot = new JLabel("Total    : ");
    JLabel total = new JLabel("Rp. " + 0);

    public BuyView(String TheJudul, String TheJam) {
        setTitle("Seat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setLocation(300, 100);

        setJudul(TheJudul);
        setJam(TheJam);
        buttonSetBounds();
        
        add(screen).setBounds(100, 30, 320, 30);
        screen.setEnabled(false);
        
        add(judul).setBounds(600, 30, 1000, 50);
        judul.setFont(new Font("Calibri", judul.getFont().getStyle(), 45));
        
        add(jam).setBounds(610, 70, 100, 50);
        jam.setFont(new Font(jam.getFont().getName(), jam.getFont().getStyle(), 16));
        
        add(theSeat).setBounds(660, 145, 100, 50);
        theSeat.setFont(new Font(theSeat.getFont().getName(), theSeat.getFont().getStyle(), 16));
        add(jumlah).setBounds(750, 145, 100, 50);
        jumlah.setFont(new Font(jumlah.getFont().getName(), jumlah.getFont().getStyle(), 16));
        
        add(theTot).setBounds(660, 185, 100, 50);
        theTot.setFont(new Font(theTot.getFont().getName(), theTot.getFont().getStyle(), 16));
        add(total).setBounds(740, 185, 100, 50);
        total.setFont(new Font(total.getFont().getName(), total.getFont().getStyle(), 16));
        
        add(confirm).setBounds(600, 300, 100, 35);
        add(back).setBounds(800, 300, 100, 35);
    }

    public void buttonSetBounds() {
        int y = 100;
        String huruf = "";
        for (int i = 0; i < 3; i++) {
            int x = 100;
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    huruf = "A";
                } else if (i == 1) {
                    huruf = "B";
                } else if (i == 2) {
                    huruf = "C";
                }
                seat[i][j] = new JButton(huruf + (j + 1));
                seat[i][j].setBackground(java.awt.Color.WHITE);
                seat[i][j].setBounds(x, y, 100, 100);
                add(seat[i][j]);
                x = x + 110;
            }
            y = y + 110;
        }
    }

    public void seatListener(ActionListener SeatListener) {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                seat[i][j].addActionListener(SeatListener);
            }
        }
    }

    public void confirmListener(ActionListener ConfirmListener) {
        confirm.addActionListener(ConfirmListener);
    }

    public void backListener(ActionListener BackListener) {
        back.addActionListener(BackListener);
    }

    public void destroy() {
        dispose();
    }

    public void Ordered(int i, int j) {
        seat[i][j].setBackground(java.awt.Color.DARK_GRAY);
    }

    public void UnOrdered(int i, int j) {
        seat[i][j].setBackground(java.awt.Color.WHITE);
    }

    public void UnClickable(int i, int j) {
        seat[i][j].setEnabled(false);
    }

    public void setJudul(String theJudul) {
        judul.setText(theJudul);
    }

    public void setJam(String theJam) {
        jam.setText(theJam);
    }

    public String getJudul() {
        return judul.getText();
    }

    public void setJumlahSeat(String Jumlah) {
        jumlah.setText(Jumlah);
    }

    public void setTotal(String Total) {
        total.setText("Rp. " + Total);
    }

    public int getConfirmMessage() {
        return JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Mencetak Tiket?", "Pop Up", JOptionPane.YES_NO_OPTION);
    }

    public void getOKMessage() {
        JOptionPane.showConfirmDialog(null, "eMoney yang Anda Miliki Tidak Mencukupi !..\nSilahkan Isi Saldo eMoney Anda!", "Gagal Beli", JOptionPane.OK_OPTION);
    }

    public void getMessage() {
        JOptionPane.showMessageDialog(null, "eMoney Anda Habis!!", "Kehabisan eMoney", JOptionPane.CANCEL_OPTION);
    }

    public void displayNormalMessage(String isi, String judul) {
        JOptionPane.showMessageDialog(null, isi, judul, JOptionPane.INFORMATION_MESSAGE);
    }
}
