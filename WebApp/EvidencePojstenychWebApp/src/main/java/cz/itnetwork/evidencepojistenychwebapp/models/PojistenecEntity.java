package cz.itnetwork.evidencepojistenychwebapp.models;

public class PojistenecEntity {

    private int pojistenecId;
    private String jmeno;
    private String prijmeni;
    private String email;
    private String telefon;
    private String uliceCislo;
    private String mesto;
    private String psc;

    public int getPojistenecId() {
        return pojistenecId;
    }

    public void setPojistenecId(int pojistenecId) {
        this.pojistenecId = pojistenecId;
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
}