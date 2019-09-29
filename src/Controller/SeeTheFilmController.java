package Controller;

import Model.BuyModel;
import Model.DataFilmModel;
import Model.LoginModel;
import Run.MenuUtama;
import View.BuyView;
import View.SeeTheFilmView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;

public class SeeTheFilmController {

    SeeTheFilmView theView;
    DataFilmModel theModel[];
    LoginModel loginModel;
    MenuUtama menuUtama;

    private String DBurl = "jdbc:mysql://localhost/bioskop?autoReconnect=true&amp;allowMultiQueries=true";
    private String DBusername = "root";
    private String DBpassword = "system";

    Connection koneksi;
    Statement statement;
    ResultSet result;
    int i = 0;

    public SeeTheFilmController(SeeTheFilmView theView, DataFilmModel theModel[], LoginModel loginModel, MenuUtama menuUtama) {
        this.theView = theView;
        this.theModel = theModel;
        this.loginModel = loginModel;
        this.menuUtama = menuUtama;
        getData();
        
        //this.theView.buyButtonListener(new BuyButtonListener());
        this.theView.callStudioListener(new CallStudioListener());
        this.theView.back2MenuListener(new Back2MenuListener());
//        System.out.println(this.theView.getIndexF());
//        System.out.println(this.theView.getIndexJ(0));
    }

    public void getData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            result = statement.executeQuery("SELECT * FROM film");
            
            while (result.next()) {
                theModel[i] = new DataFilmModel();
                String id_film = result.getString("id_film");
                String judulS = result.getString("judul");
                String rilisS = result.getString("tgl_rilis");
                double hargaS = result.getDouble("harga");
                String sinopsisS = result.getString("sinopsis");
                //String jamS = result.getString("Jam");
                theModel[i].setJudul(judulS);
                theModel[i].setHarga(hargaS);
                theModel[i].setRilis(rilisS);
                theModel[i].setSinopsis(sinopsisS);
                theModel[i].setID(id_film);
                
                theView.setPanel(i);
                getTimeButton(i);

                i++;
            }

            statement.close();
            koneksi.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeeTheFilmView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SeeTheFilmView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //private class BuyButtonListener implements ActionListener {

//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            int i;
//            for (i = 0; i <= theView.getIndex(); i++) {
////                if (theView.buyButton[i] == ae.getSource()) {
//
//                    String TheJudul = theView.getJudul(i);
//                    String TheJam = theView.getJam(i);
//                    Double TheHarga = theModel[i].getHarga();
//
//                    BuyView aView = new BuyView(TheJudul, TheJam);
//                    BuyModel aModel = new BuyModel(aView, TheHarga, i, loginModel);
//                    BuyController aController = new BuyController(aView, aModel, loginModel, theView, menuUtama);
//
//                    theView.invisible();
//                    menuUtama.invisible();
//                }
            //}

        //}

    //}
    
    public void getTimeButton(int index_film){
     try{
            int j = 0;
            //System.out.println("Berhasil select");
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi2 = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            Statement statement2 = koneksi2.createStatement();
            ResultSet result2 = statement2.executeQuery("SELECT j.waktu, t.id_tayang from jadwal j, tayang t where t.id_jadwal = j.id_jadwal and t.id_film = " + theModel[index_film].getID());
            //int id = Integer.parseInt(id_film);
            while(result2.next()){
                
                theModel[index_film].setJadwal(result2.getString("waktu"), j);
                theModel[index_film].setIdTayang(result2.getString("id_tayang"), j);
                System.out.println(theModel[index_film].getJadwal(1));
                theView.setTimeButton(index_film,j);
                j++;
            
            }
            
            statement2.close();
            koneksi2.close();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(SeeTheFilmView.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (SQLException ex) {
                Logger.getLogger(SeeTheFilmView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class Back2MenuListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent ae) {
            menuUtama.setVisible(true);
            theView.setVisible(false);
        }
    }

    
    private class CallStudioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            for(int i=0 ; i<=theView.getIndexF() ; i++){
                int getSumJadwal = theView.getIndexJ(i);
//                System.out.println("YOYOYO");
                for(int j=0 ; j<=getSumJadwal ; j++){
                    if (theView.timeButton[i][j] == ae.getSource()) {
//                        System.out.println("YESYESYES");
                        String Judul = theModel[i].getJudul();
                        String Jadwal = theModel[i].getJadwal(j);
                        Double TheHarga = theModel[i].getHarga();
                        int idTayang = theModel[i].getIdTayang(j);

                        BuyView studioView = new BuyView(Judul, Jadwal);
                        BuyModel studioModel = new BuyModel(studioView, TheHarga, idTayang, loginModel);
                        BuyController studioController = new BuyController(studioView, studioModel, loginModel, theView, menuUtama);

                        theView.invisible();
                        menuUtama.invisible();
                    }
                }
            }
        }
    }
}
