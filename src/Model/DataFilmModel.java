package Model;


public class DataFilmModel {

    private String rilis, judul, sinopsis, jam, id_film,id_tayang[] = new String[10];
    private double harga;
    private String jadwal[] = new String[10];

    public DataFilmModel() {
        this.judul = "";
        this.rilis = "";
        this.sinopsis = "";
        this.harga = 0;
    }
    
    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public String getID(){
        return id_film;
    }
    
    public void setID(String id_film){
        this.id_film = id_film;
    }

    public String getJadwal(int i) {
        return jadwal[i];
    }

    public void setJadwal(String jadwal,int i) {
        this.jadwal[i] = jadwal;
    }
    
    public void setIdTayang(String id, int index){
        this.id_tayang[index] = id;
    }
    
    public int getIdTayang(int index){
        return Integer.parseInt(id_tayang[index]);
    }
    
}
