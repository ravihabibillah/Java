package View;

import Controller.SeeTheFilmController;
import Model.DataFilmModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SeeTheFilmView extends JFrame {

    DataFilmModel model[];
    public int x = 0, indexF,indexJ[] = new int[5], indexButtonTime = 0;
    public int jarakButtonInFilm = 0, jarakButtonAntarFilm = 0, idFilmSebelumnya = 0;
    
    JLabel judul[] = new JLabel[10];
    JLabel rilis[] = new JLabel[10];
    JLabel harga[] = new JLabel[10];
    //JLabel jam[] = new JLabel[10];

    //public JButton buyButton[] = new JButton[10];
    public JButton timeButton[][] = new JButton[10][5];
    public JButton back2Menu = new JButton("Back");

    JPanel panelUtama = new JPanel(null);
    JScrollPane scroll = new JScrollPane(panelUtama);

    JTextArea sinopsis[] = new JTextArea[10];

    public SeeTheFilmView(DataFilmModel model[]) {

        this.model = model;
        setTitle("List FILM");
        setSize(1015, 550);
        setLocation(300, 100);
        setLayout(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelUtama.setPreferredSize(new Dimension(2000, 500));
        add(scroll).setBounds(0, 0, 1000, 500);
        back2Menu.setBackground(java.awt.Color.CYAN);
        panelUtama.add(back2Menu).setBounds(50, 425, 100, 30);

    }

    public void setPanel(int i) {

        judul[i] = new JLabel(model[i].getJudul());     //ngisi text Label judul
        rilis[i] = new JLabel(model[i].getRilis());     //ngisi text label rilis
        harga[i] = new JLabel("Rp " + String.valueOf(model[i].getHarga())); //ngisi text label harga
        sinopsis[i] = new JTextArea(model[i].getSinopsis());    //ngisi text textArea sinopsis
        //buyButton[i] = new JButton("Buy Ticket");
        //jam[i] = new JLabel(model[i].getJam() + " WIB");

        panelUtama.add(judul[i]).setBounds(50 + x, 0, 200, 70);         //set posisi judul
        panelUtama.add(harga[i]).setBounds(400 + x, 30, 100, 25);       //set posisi harga
        panelUtama.add(sinopsis[i]).setBounds(50 + x, 100, 410, 200);   //set posisi sinopsis
        panelUtama.add(rilis[i]).setBounds(60 + x, 50, 100, 25);        //set posisi tgl rilis
        //panelUtama.add(buyButton[i]).setBounds(200 + x, 370, 100, 25);
        //panelUtama.add(jam[i]).setBounds(405 + x, 50, 100, 25);

        x += 600;   //menggeser posisi

        judul[i].setFont(new Font(judul[i].getFont().getName(), judul[i].getFont().getStyle(), 20));

        sinopsis[i].setLineWrap(true);
        sinopsis[i].setEditable(false);
        sinopsis[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        indexF = i;
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
//    public String getJam(int i){
//        return jam[i].getText();
//    }
    
    
    public int getIndexF(){
        return indexF;
    }
    
    public int getIndexJ(int i){
        return indexJ[i];
    }

    public void callStudioListener(ActionListener CallStudioListener) {
//        for (int i = 0; i <= index; i++) {
//            //buyButton[i].addActionListener(BuyButtonListener);
//        }
//        System.out.println("Masuk Studio");
        for(int i=0 ; i<=indexF ; i++){
            int tempJ = indexJ[i];
            
//            System.out.println(tempJ);
            
            for(int j=0 ; j<=tempJ ; j++){
                timeButton[i][j].addActionListener(CallStudioListener);
            }
        }
    }

//    public static void main(String[] args) {
//        FilmModel Mod[] = new FilmModel[10];
//        SeeTheFilmView view = new SeeTheFilmView(Mod);
//        SeeTheFilmController control = new SeeTheFilmController(view, Mod);
//    }
    
    
    public void setTimeButton(int index_film,int dex){
        
        if(idFilmSebelumnya != index_film){     //jika ganti id film
            jarakButtonInFilm = 0;
            idFilmSebelumnya = index_film;
            
            indexButtonTime = 0;
            jarakButtonAntarFilm = 600 * index_film;
        }
        if(idFilmSebelumnya == index_film){
            timeButton[index_film][indexButtonTime] = new JButton(model[index_film].getJadwal(dex));
        
            panelUtama.add(timeButton[index_film][indexButtonTime]).setBounds(50 + jarakButtonInFilm + jarakButtonAntarFilm, 370, 80, 25);
            //System.out.println("Berhasil Tampil");
            
            
            timeButton[index_film][indexButtonTime].addActionListener(null);
            
            
            indexJ[index_film] = indexButtonTime;
//            System.out.println(indexButtonTime);
            
            jarakButtonInFilm = jarakButtonInFilm + 90;
            indexButtonTime++;
            
            
//            jarakButtonAntarFilm = 0;
            
        }
        
    }
    
    public void back2MenuListener(ActionListener Back2MenuListener){
        back2Menu.addActionListener(Back2MenuListener);
    }
}
