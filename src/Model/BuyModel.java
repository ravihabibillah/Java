package Model;

import View.BuyView;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class BuyModel {

    private int jumlah;
    private double total, harga;
    private String judul, theIndex;
    int idTayang,idKursi[] = new int[10];
    BuyView theView;
    LoginModel loginModel;
    private boolean warna[][] = new boolean[3][3];
    private int status[][] = new int[3][3];
    private String DBurl = "jdbc:mysql://localhost/bioskop?autoReconnect=true&amp;allowMultiQueries=true";
    private String DBusername = "root";
    private String DBpassword = "system";
    Connection koneksi,koneksi2;
    Statement statement,statement2;
    ResultSet result, result2;

    public BuyModel(BuyView theView, Double harga, int idTayang, LoginModel loginModel) {
        this.theView = theView;
        this.harga = harga;
        this.loginModel = loginModel;
        this.idTayang = idTayang;

        statusAwal();
        getDatabase(idTayang);
        setButton();
    }

    public void ButtonEvent(java.awt.event.ActionEvent ae) {
        int i, j = 0,id=0;
        boolean check = false;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (theView.seat[i][j] == ae.getSource()) {
                    check = true;
                    idKursi[id] = id;
                    break;
                }id++;
            }
            if (check) {
                break;
            }
        }
        if (warna[i][j] == false) {
            theView.Ordered(i, j);
            warna[i][j] = true;
            jumlah++;
            total += harga;
            status[i][j] = 1;
        } else {
            theView.UnOrdered(i, j);
            warna[i][j] = false;
            jumlah--;
            total -= harga;
            status[i][j] = 0;
        }
        theView.setJumlahSeat(String.valueOf(jumlah));
        theView.setTotal(String.valueOf(total));
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void statusAwal() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                status[i][j] = 0;
            }
        }
    }

    public void getDatabase(int idTayang) {
        try {
            int temp;
            boolean check = false;
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
//            theIndex = "film" + String.valueOf(index);
//            result = statement.executeQuery("SELECT * FROM " + theIndex);
//            while (result.next()) {
//                temp = result.getInt("id_status");
//                if (temp != 0 || temp != 1) {
//                    check = true;
//                    break;
//                }
//            }
//            if (check) {
            
            result = statement.executeQuery("SELECT * FROM booking where id_tayang = " + idTayang );
            System.out.println(idTayang);
            int i = 0, j = 0;
//                result2 = statement.executeQuery("SELECT * FROM " + theIndex);
            while (result.next()) {
                status[i][j] = result.getInt("id_status");

                j += 1;
                if (j > 2) {
                    j = 0;
                    i += 1;
                }
            }
//            }
            statement.close();
            koneksi.close();

        } catch (SQLException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setButton() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (status[i][j] == 1) {
                    theView.Ordered(i, j);
                    theView.UnClickable(i, j);
                }
            }
        }
    }

    public void SetKursi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
//            statement.executeUpdate("DELETE FROM " + theIndex + " WHERE 1");
            int id =0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
//                    statement.executeUpdate("INSERT into " + theIndex + " VaLUES ('" + status[i][j] + "')");
                    if(status[i][j] == 1){
                        statement.executeUpdate("UPDATE booking SET id_status = "+ status[i][j] +", id_pembeli = " + loginModel.getID() +" WHERE id_tayang = " + idTayang +" AND id_kursi = "+ idKursi[id]);
                        
                    }
                    id++;
                }
            }
            statement.close();
            koneksi.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void SetEmoney() {
        try {
            double eMoney = 0, eMoneyBaru;

            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            result = statement.executeQuery("SELECT * FROM pembeli WHERE id_pembeli =" + loginModel.getID());
            while (result.next()) {
                eMoney = result.getDouble("eMoney");
            }

            eMoneyBaru = eMoney - total;

            if (eMoneyBaru < 0) {
                theView.getOKMessage();
            } else if (eMoneyBaru > 0) {
                int answer = theView.getConfirmMessage();

                if (answer == 0) {
                    statement.executeUpdate("UPDATE pembeli SET eMoney='" + eMoneyBaru + "' WHERE id_pembeli= " + loginModel.getID());
                    theView.displayNormalMessage("Berhasil memesan Kursi", "Pembelian Berhasil");
                    SetKursi();
                }
            } else {
                int answer = theView.getConfirmMessage();

                if (answer == 0) {
                    statement.executeUpdate("UPDATE pembeli SET eMoney='" + eMoneyBaru + "' WHERE id_pembeli= " + loginModel.getID());
                    SetKursi();
                    theView.getMessage();
                }
            }
            statement.close();
            koneksi.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
