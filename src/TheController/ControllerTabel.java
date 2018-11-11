/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheController;

import TheModel.ModelForm;
import TheView.ViewForm;
import TheView.ViewTabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import theConnection.Koneksi;

/**
 *
 * @author DELL
 */
public class ControllerTabel {

    ModelForm theModel[];
    ViewTabel theView;
    Koneksi konek;

    public ControllerTabel(ViewTabel theView, Koneksi konek, ModelForm[] theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.konek = konek;
        konek.ReadData();
        this.theView.setTabel(this.theModel);
        this.theView.hapusButton(new HapusListener());
        this.theView.updateButton(new UpdateListener());
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int row = theView.tabel.getSelectedRow();
            String nimS = theView.tabel.getValueAt(row, 0).toString();
            String namaS = theView.tabel.getValueAt(row, 1).toString();
            String kelasS = theView.tabel.getValueAt(row, 2).toString();
            String semesterS = theView.tabel.getValueAt(row, 3).toString();
            int sksS = Integer.parseInt(theView.tabel.getValueAt(row, 4).toString());
            konek.UpdateData(row,nimS,namaS,kelasS,semesterS,sksS);
            
//            theView.dispose();
        }
    }

    private class HapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            konek.HapusOnClick();
            theView.hapusRow();
            konek.Close();
        }
    }
}
