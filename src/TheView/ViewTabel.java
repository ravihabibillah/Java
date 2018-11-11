/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheView;

import TheModel.ModelForm;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import theConnection.Koneksi;

/**
 *
 * @author DELL
 */
public class ViewTabel extends JFrame {

    ModelForm form[];

    DefaultTableModel tabelModel = new DefaultTableModel(new Object[]{
        "NIM",
        "Nama",
        "Kelas",
        "Semester",
        "Jumlah SKS"
    }, 20);

    public JTable tabel = new JTable(tabelModel);
    JScrollPane scroll = new JScrollPane(tabel);
    JButton hapusB = new JButton("Hapus");
    JButton updateB = new JButton("Update");
    JLabel label = new JLabel("*Hanya bisa update satu persatu / pilih salah satu yang mau di edit, kemudian update");
    public ViewTabel() {
        setLayout(null);
        setTitle("Form");
        setVisible(true);
        setSize(540, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(700, 150);
        
        add(scroll).setBounds(0, 0, 530, 200);

        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(90);

        add(hapusB).setBounds(30, 240, 100, 25);
        add(updateB).setBounds(150, 240, 100, 25);
        add(label).setBounds(20, 200, 500, 25);
    }

    public void setTabel(ModelForm form[]) {
        for (int i = 0; i < 10; i++) {
            if (form[i] == null) {
                break;
            } else {
                tabel.setValueAt(form[i].getNim(), i, 0);
                tabel.setValueAt(form[i].getNama(), i, 1);
                tabel.setValueAt(form[i].getKelas(), i, 2);
                tabel.setValueAt(form[i].getSemester(), i, 3);
                tabel.setValueAt(form[i].getSks(), i, 4);
            }
        }
    }

    public void hapusButton(ActionListener HapusListener) {
        hapusB.addActionListener(HapusListener);
    }
    
    public void updateButton(ActionListener UpdateListener){
        updateB.addActionListener(UpdateListener);
    }

    public void hapusRow() {
        tabelModel.removeRow(tabel.getSelectedRow());
    }

    public String getHapus() {
        int row = tabel.getSelectedRow();
        int column = tabel.getSelectedColumn();
        String check = tabel.getValueAt(row, column).toString();
        return check;
    }

    public void destroy(){
        dispose();
    }
//    public static void main(String[] args) {
//        new ViewTabel();
//    }
}
