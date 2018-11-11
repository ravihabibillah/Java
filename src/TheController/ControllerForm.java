/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheController;

import TheModel.*;
import TheView.*;
import java.awt.event.*;
import theConnection.Koneksi;

/**
 *
 * @author DELL
 */
public class ControllerForm {

    ViewForm theView;
    ViewTabel theTabel;
    ModelForm theModel;
    boolean Check = false;

    public ControllerForm(ViewForm theView, ModelForm theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addSimpanListener(new SimpanListener());
        this.theView.addKembaliListener(new KembaliListener());
        this.theView.addTampilListener(new TampilListener());
    }

    private class TampilListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.setNewLocation();
            ModelForm Form[] = new ModelForm[10];
            ViewTabel View = new ViewTabel();
            Koneksi Konek = new Koneksi(Form, View);
            ControllerTabel Control = new ControllerTabel(View, Konek, Form);
            Check = true;
            theTabel = View;
        }

    }

    private class KembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.destroy();
            theTabel.destroy();
            ViewLogin View = new ViewLogin();
            ModelLogin Model = new ModelLogin();
            ControllerLogin Control = new ControllerLogin(View, Model);
        }
    }

    private class SimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            
            Koneksi konek = new Koneksi();
            theModel.setNim(theView.getNimTF());
            theModel.setNama(theView.getNamaTF());
            theModel.setKelas(theView.getKelasTF());
            theModel.setSemester(theView.getSemesterTF());
            theModel.setSks(theView.getSksTF());

            konek.Create(theModel);
            konek.Close();
            if (Check) {
                theTabel.destroy();
                ModelForm Form[] = new ModelForm[10];
                ViewTabel View = new ViewTabel();
                Koneksi Konek = new Koneksi(Form, View);
                ControllerTabel Control = new ControllerTabel(View, Konek, Form);
            }
        }
    }

}
