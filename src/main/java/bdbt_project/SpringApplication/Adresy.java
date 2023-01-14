package bdbt_project.SpringApplication;

public class Adresy {
    private int id_adresu;
    private int id_poczty;
    private String miasto;
    private String ulica;
    private String nr_domu;
    private int nr_lokalu;


    public Adresy(int id_adresu, int id_poczty, String miasto, String ulica, String nr_domu, int nr_lokalu) {
        this.id_adresu = id_adresu;
        this.id_poczty = id_poczty;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.nr_lokalu = nr_lokalu;
    }

    public Adresy(){

    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public int getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(int nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    @Override
    public String toString() {
        return "Adresy [id_adresu=" + id_adresu + ", id_poczty=" + id_poczty + ", miasto=" + miasto +", ulica=" + ulica + ", nr_domu=" + nr_domu +", nr_lokalu=" + nr_lokalu + "]";
    }

}
