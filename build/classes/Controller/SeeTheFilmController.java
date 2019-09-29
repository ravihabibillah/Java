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

public class SeeTheFilmController {

    SeeTheFilmView theView;
    DataFilmModel theModel[];
    LoginModel loginModel;
    MenuUtama menuUtama;

    private String DBurl = "jdbc:mysql://localhost/datafilm";
    private String DBusername = "root";
    private String DBpassword = "";

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
        this.theView.buyButtonListener(new BuyButtonListener());
    }

    public void getData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            result = statement.executeQuery("SELECT * FROM data");

            while (result.next()) {
                theModel[i] = new DataFilmModel();
                String judulS = result.getString("Judul");
                String tahunS = result.getString("Tahun");
                double hargaS = result.getDouble("Harga");
                String sinopsisS = result.getString("Sinopsis");
                String jamS = result.getString("Jam");
                theModel[i].setJudul(judulS);
                theModel[i].setHarga(hargaS);
                theModel[i].setTahun(tahunS);
                theModel[i].setSinopsis(sinopsisS);
                theModel[i].setJam(jamS);
                theView.setPanel(i);

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

    private class BuyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int i;
            for (i = 0; i <= theView.getIndex(); i++) {
                if (theView.buyButton[i] == ae.getSource()) {

                    String TheJudul = theView.getJudul(i);
                    String TheJam = theView.getJam(i);
                    Double TheHarga = theModel[i].getHarga();

                    BuyView aView = new BuyView(TheJudul, TheJam);
                    BuyModel aModel = new BuyModel(aView, TheHarga, i, loginModel);
                    BuyController aController = new BuyController(aView, aModel, loginModel, theView, menuUtama);

                    theView.invisible();
                    menuUtama.invisible();
                }
            }

        }

    }
}
