package bdbt_project.SpringApplication;

public class Oceanarium {
    private int id_oceanarium;
    private int id_adresu;
    private String nazwa;
    private String email;
    private String data_otwarcia;
    private int telefon;




    public Oceanarium(int id_oceanarium, int id_adresu, String nazwa, String email, String data_otwarcia, int telefon) {
        this.id_oceanarium = id_oceanarium;
        this.id_adresu = id_adresu;
        this.nazwa = nazwa;
        this.email = email;
        this.data_otwarcia = data_otwarcia;
        this.telefon = telefon;
    }

    public Oceanarium() {

    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_otwarcia() {
        return data_otwarcia;
    }

    public void setData_otwarcia(String data_otwarcia) {
        this.data_otwarcia = data_otwarcia;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Oceanarium [id_oceanarium=" + id_oceanarium + ", id_adresu=" + id_adresu + ", nazwa=" + nazwa + ", email=" + email + ", data_otwarcia=" + data_otwarcia + ", telefon=" + telefon + "]";
    }
}

