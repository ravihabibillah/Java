
package TheModel;


public class ModelForm {
    private String nim,nama,kelas,semester;
    private int sks;
    
    public ModelForm(){
        
    }

    public ModelForm(String nim, String nama, String kelas, String semester, int sks) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.semester = semester;
        this.sks = sks;
    }
    

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
