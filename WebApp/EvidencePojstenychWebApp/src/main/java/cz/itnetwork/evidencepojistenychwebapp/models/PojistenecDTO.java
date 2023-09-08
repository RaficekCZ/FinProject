package cz.itnetwork.evidencepojistenychwebapp.models;

public class PojistenecDTO {
    
    private Integer pojistenecId;
    private String jmeno;
    private String prijmeni;
    private String email;
    private String telefon;
    private String uliceCislo;
    private String mesto;
    private String psc;
    
    private String celeJmeno;
    private String adresa;

    public PojistenecDTO(Integer pojistenciId, String jmeno, String prijmeni, String email, String telefon, String uliceCislo, String mesto, String psc) {
        this.pojistenecId = pojistenciId;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        this.telefon = telefon;
        this.uliceCislo = uliceCislo;
        this.mesto = mesto;
        this.psc = psc;

        this.celeJmeno = jmeno + " " + prijmeni;
        this.adresa = uliceCislo + ", " + mesto + ", " + psc;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUliceCislo() {
        return uliceCislo;
    }

    public void setUliceCislo(String uliceCislo) {
        this.uliceCislo = uliceCislo;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    public int getPojistenecId() {
        return pojistenecId;
    }
    
    public void setPojistenecId(int pojistenecId) {
        this.pojistenecId = pojistenecId;
    }
}