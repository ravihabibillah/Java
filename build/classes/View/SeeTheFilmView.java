package View;

import Model.DataFilmModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeeTheFilmView extends JFrame {

    DataFilmModel model[];
    public int x = 0, index;
    JLabel judul[] = new JLabel[10];
    JLabel tahun[] = new JLabel[10];
    JLabel harga[] = new JLabel[10];
    JLabel jam[] = new JLabel[10];

    public JButton buyButton[] = new JButton[10];

    JPanel panelUtama = new JPanel(null);
    JScrollPane scroll = new JScrollPane(panelUtama);

    JTextArea sinopsis[] = new JTextArea[10];

    public SeeTheFilmView(DataFilmModel model[]) {

        this.model = model;
        setTitle("List FILM");
        setSize(1015, 500);
        setLocation(300, 100);
        setLayout(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelUtama.setPreferredSize(new Dimension(2000, 400));
        add(scroll).setBounds(0, 0, 1000, 465);

    }

    public void setPanel(int i) {

        judul[i] = new JLabel(model[i].getJudul());
        tahun[i] = new JLabel(model[i].getTahun());
        harga[i] = new JLabel("Rp " + String.valueOf(model[i].getHarga()));
        sinopsis[i] = new JTextArea(model[i].getSinopsis());
        buyButton[i] = new JButton("Buy Ticket");
        jam[i] = new JLabel(model[i].getJam() + " WIB");

        panelUtama.add(judul[i]).setBounds(50 + x, 0, 200, 70);
        panelUtama.add(harga[i]).setBounds(400 + x, 30, 100, 25);
        panelUtama.add(sinopsis[i]).setBounds(50 + x, 100, 410, 200);
        panelUtama.add(tahun[i]).setBounds(60 + x, 50, 100, 25);
        panelUtama.add(buyButton[i]).setBounds(200 + x, 370, 100, 25);
        panelUtama.add(jam[i]).setBounds(405 + x, 50, 100, 25);

        x += 600;

        judul[i].setFont(new Font(judul[i].getFont().getName(), judul[i].getFont().getStyle(), 20));

        sinopsis[i].setLineWrap(true);
        sinopsis[i].setEditable(false);
        sinopsis[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        index = i;
    }

    public void destroy() {
        dispose();
    }

    public void appear() {
        setVisible(true);
    }
    
    public void invisible(){
        setVisible(false);
    }

    public String getJudul(int i) {
        return judul[i].getText();
    }
    public String getJam(int i){
        return jam[i].getText();
    }
    
    public int getIndex(){
        return index;
    }

    public void buyButtonListener(ActionListener BuyButtonListener) {
        for (int i = 0; i <= index; i++) {
            buyButton[i].addActionListener(BuyButtonListener);
        }
    }

//    public static void main(String[] args) {
//        FilmModel Mod[] = new FilmModel[10];
//        SeeTheFilmView view = new SeeTheFilmView(Mod);
//        SeeTheFilmController control = new SeeTheFilmController(view, Mod);
//    }
}
