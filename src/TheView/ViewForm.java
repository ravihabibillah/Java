package TheView;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewForm extends JFrame{
    
    JLabel nimLbl = new JLabel("NIM");
    JLabel namaLbl = new JLabel("Nama");
    JLabel kelasLbl = new JLabel("Kelas");
    JLabel semesterLbl = new JLabel("Semester");
    JLabel sksLbl = new JLabel("Jumlah SKS");
    JLabel title = new JLabel("Form");
    
    public JTextField nimTF = new JTextField();
    public JTextField namaTF = new JTextField();
    public JTextField kelasTF = new JTextField();
    public JTextField semesterTF = new JTextField();
    public JTextField sksTF = new JTextField();

    JButton simpanBtn = new JButton("Simpan");
    JButton kembaliBtn = new JButton("Kembali");
    JButton tampilBtn = new JButton("Tampil");

    public ViewForm() {
        setLayout(null);
        setTitle("Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 20));
        
        add(title).setBounds(200, 10, 100, 30);
        add(nimLbl).setBounds(90, 65, 70, 10);
        add(namaLbl).setBounds(90, 115, 70, 10);
        add(kelasLbl).setBounds(90, 165, 70, 10);
        add(semesterLbl).setBounds(90, 215, 70, 10);
        add(sksLbl).setBounds(90, 265, 70, 10);
        add(nimTF).setBounds(220, 60, 150, 20);
        add(namaTF).setBounds(220, 110, 150, 20);
        add(kelasTF).setBounds(220, 160, 150, 20);
        add(semesterTF).setBounds(220, 210, 150, 20);
        add(sksTF).setBounds(220, 260, 150, 20);
        add(kembaliBtn).setBounds(90, 310, 80, 25);
        add(simpanBtn).setBounds(190, 310, 80, 25);
        add(tampilBtn).setBounds(290, 310, 80, 25);
    }

    public String getNimTF() {
        return nimTF.getText();
    }

    public String getNamaTF() {
        return namaTF.getText();
    }

    public String getKelasTF() {
        return kelasTF.getText();
    }

    public String getSemesterTF() {
        return semesterTF.getText();
    }

    public int getSksTF() {
        return Integer.parseInt(sksTF.getText());
    }
    
    public void addSimpanListener(ActionListener SimpanListener){
        simpanBtn.addActionListener(SimpanListener);
    }
    
    public void addKembaliListener(ActionListener KembaliListener){
        kembaliBtn.addActionListener(KembaliListener);
    }
    
    public void addTampilListener(ActionListener TampilListener){
        tampilBtn.addActionListener(TampilListener);
    }
    
    public void destroy(){
        dispose();
    }
    
    public void setNewLocation(){
        setLocation(200, 150);}
}
