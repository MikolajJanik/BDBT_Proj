package bdbt_project.SpringApplication;

public class Zbiorniki {
    private int id_zbiornika;
    private int id_oceanarium;
    private String nazwa;
    private int pojemnosc;
    private String wymiary;
    private String typ_zbiornika;
    private String strefa;
    private String data_przegladu;
    private String opis;





    public Zbiorniki(int id_zbiornika, int id_oceanarium, String nazwa, int pojemnosc, String wymiary, String typ_zbiornika, String strefa, String data_przegladu, String opis) {
        this.id_zbiornika = id_zbiornika;
        this.id_oceanarium = id_oceanarium;
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.wymiary = wymiary;
        this.typ_zbiornika = typ_zbiornika;
        this.strefa = strefa;
        this.data_przegladu = data_przegladu;
        this.opis = opis;

    }

    public Zbiorniki() {

    }

    public int getId_zbiornika() {
        return id_zbiornika;
    }

    public void setId_zbiornika(int id_zbiornika) {
        this.id_zbiornika = id_zbiornika;
    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
    }

    public String getTyp_zbiornika() {
        return typ_zbiornika;
    }

    public void setTyp_zbiornika(String typ_zbiornika) {
        this.typ_zbiornika = typ_zbiornika;
    }
    public String getStrefa() {
        return strefa;
    }

    public void setStrefa(String strefa) {
        this.strefa = strefa;
    }
    public String getData_przegladu() {
        return data_przegladu;
    }

    public void setData_przegladu(String data_przegladu) {
        this.data_przegladu = data_przegladu;
    }
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String toString() {
        return "Zbiorniki [id_zbiornika=" + id_zbiornika + ", id_oceanarium=" + id_oceanarium + ", nazwa=" + nazwa + ", pojemnosc=" + pojemnosc + ", wymiary=" + wymiary + ", typ_zbiornika=" + typ_zbiornika + ", strefa=" + strefa + ", data_przegladu=" + data_przegladu + ", opis=" + opis + "]";
    }
}

