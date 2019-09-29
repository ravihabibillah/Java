/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BuyModel;
import Model.DataFilmModel;
import Model.LoginModel;
import Run.MenuUtama;
import View.BuyView;
import View.SeeTheFilmView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DELL
 */
public class BuyController {

    BuyView theView;
    BuyModel theModel;
    LoginModel loginModel;
    SeeTheFilmView FilmView;
    MenuUtama menuUtama;
    
    public BuyController(BuyView theView, BuyModel theModel, LoginModel loginModel,SeeTheFilmView FilmView,MenuUtama menuUtama) {
        this.theView = theView;
        this.theModel = theModel;
        this.loginModel = loginModel;
        this.FilmView = FilmView;
        this.menuUtama = menuUtama;
        
        this.theView.seatListener(new SeatListener());
        this.theView.confirmListener(new ConfirmListener());
        this.theView.backListener(new BackListener());
        theModel.setJudul(theView.getJudul());

    }

    private class SeatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theModel.ButtonEvent(ae);
        }
    }

    private class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theModel.SetEmoney();
        }
    }

    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.destroy();
            FilmView.appear();
//            menuUtama.appear();
        }

    }
}
