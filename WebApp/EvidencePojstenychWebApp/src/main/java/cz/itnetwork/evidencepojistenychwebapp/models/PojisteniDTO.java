package cz.itnetwork.evidencepojistenychwebapp.models;

public class PojisteniDTO {

    private String nazev;
    private String min;
    private String max;

    public PojisteniDTO(String nazev, String min, String max) {
        this.nazev = nazev;
        this.min = min;
        this.max = max;
    }
    
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

}