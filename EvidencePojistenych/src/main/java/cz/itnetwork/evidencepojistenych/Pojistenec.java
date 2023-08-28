package cz.itnetwork.evidencepojistenych;

public class Pojistenec {
    
    // Nutné atributy každého pojištěnce
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefonniCislo;
    
    // Konstrukor k inicializaci jednotlivých pojištěnců
    public Pojistenec(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
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

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(int telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }
    
    // Metoda k psaní mezer (správnému formátování) při dotazu na textový atribut pojištěnce - při výpisu tohoto textu
    public String mezerovaniString(String text) {
        int maxPocetTextovychZnaku = 20;
        int pocetMezer = maxPocetTextovychZnaku - text.length();
        if (pocetMezer <= 0) {
            pocetMezer = 1;
        }
        String mezery = "";
        for (int i = 0; i < pocetMezer; i++) {
            mezery += " ";
        }
        return mezery;
    }
    
    // Metoda k psaní mezer (správnému formátování) při dotazu na číselný atribut pojištěnce - při výpisu tohoto čísla
    public String mezerovaniInt(int cislo) {
        int maxPocetTextovychZnaku = 10;
        int pocetMezer = 0;
        if (cislo < 10) {
            pocetMezer = maxPocetTextovychZnaku - 1;
        }
        else if (cislo >= 10 && cislo < 100) {
            pocetMezer = maxPocetTextovychZnaku - 2;
        }
        else {
            pocetMezer = maxPocetTextovychZnaku - 3;
        }
        String mezery = "";    
        for (int i = 0; i < pocetMezer; i++) {
            mezery += " ";
        }
        return mezery;
    }
    
    // Přepsání metody toString() k textovému vypsání daného pojištěnce
    @Override
    public String toString() {
        return (prijmeni + mezerovaniString(this.getPrijmeni()) + jmeno + mezerovaniString(this.getJmeno()) + vek + mezerovaniInt(this.vek) + telefonniCislo);
    }
}