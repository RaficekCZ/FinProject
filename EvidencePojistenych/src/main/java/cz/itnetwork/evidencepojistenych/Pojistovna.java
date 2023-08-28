package cz.itnetwork.evidencepojistenych;

import java.util.ArrayList;
import java.util.Scanner;

public class Pojistovna {

    private DatabazePojistencu databaze; // Atribut pro založení ukládací databáze
    private Scanner sc;
    private int minVek = 0; // Atribut pro kontrolu minimálního věku pojištěnce
    private int maxVek = 150; // Atribut pro kontrolu maximálního věku pojištěnce
    
    // Konstruktor pro inicializaci této třídy (a atributů DatabazePojistencu a Scanner)
    public Pojistovna() {
        databaze = new DatabazePojistencu();
        sc = new Scanner(System.in, "Windows-1250");
    }
    
    /* Metoda pro založení pojištěnce a jeho uložení do databáze
    Bez úpravy (kontroly) jména a příjmení. Lidé se v dnešním světě klidně mohou jmenovat jakkoli */
    public void zalozPojistence() {
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = sc.nextLine();
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = sc.nextLine();
        System.out.println("Zadejte věk pojištěného:");
        int vek = kontrolaVeku(kontrolaCisla());
        System.out.println("Zadejte české telefonní číslo pojištěného ve tvaru [XXXXXXXXX]:");
        int telefonniCislo = kontrolaTelefonnihoCisla(kontrolaCisla());
        databaze.zalozPojistence(jmeno, prijmeni, vek, telefonniCislo);
        System.out.println();
        System.out.println("Data byla uložena do databáze. Pokračujte stisknutím klávesy ENTER...");
        sc.nextLine();
    }
    
    // Metoda pro výpis všech pojištěnců uložených v databázi
    public void vypisVsechnyPojistence() {
        ArrayList<Pojistenec> pojistenci = databaze.vyhledejVsechnyPojistence();
        if (pojistenci.size() > 0) {
            vypisNadpisuPojistencu();
            for (Pojistenec pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }
        }
        else {
            System.out.println("Nebyly nalezeny žádné záznamy o pojištěných osobách.");
        }
        System.out.println();
        System.out.println("Data byla vypsána. Pokračujte stisknutím klávesy ENTER...");
        sc.nextLine();
    }
    
    // Metoda pro výpis konkrétního pojištěnce uloženého v databázi
    public void vypisDanehoPojistence() {
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = sc.nextLine();
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = sc.nextLine();
        ArrayList<Pojistenec> pojistenci = databaze.vyhledejDanehoPojistence(jmeno, prijmeni);
        System.out.println();
        if (pojistenci.size() > 0) {
            vypisNadpisuPojistencu();
            for (Pojistenec pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }            
        }
        else {
            System.out.println("Nebyly nalezeny žádné záznamy o osobě: " + jmeno + " " + prijmeni);
        }
        System.out.println();
        System.out.println("Data byla vypsána. Pokračujte stisknutím klávesy ENTER...");
        sc.nextLine();
    }
    
    // Metoda pro kontrolu, zda-li bylo přes Scanner zadáno číslo
    private int kontrolaCisla() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception ex) {
                System.out.println("Nezadáno validní číslo. Prosím, zadejte jej znovu.");
            }
        }
    }
    
    // Metoda pro kontrolu, zda-li bylo přes Scanner zadáno validní číslo pro věk pojištěnce
    private int kontrolaVeku(int vek) {
        while (true) {
            if (vek > minVek && vek < maxVek) {
                return vek;
            }
            else {
                System.out.println("Tento věk neodpovídá lidskému životu. Prosím, zadejte věk znovu.");
                vek = kontrolaCisla();
            }
        }
    }
    
    // Metoda pro kontrolu, zda-li bylo přes Scanner zadáno validní číslo pro telefonní číslo pojištěnce
    private int kontrolaTelefonnihoCisla(int telefonniCislo) {
        while (true) {
            if (telefonniCislo >= 100000000 && telefonniCislo <= 999999999) {
                return telefonniCislo;
            }
            else {
                System.out.println("Nezadáno validní číslo. Prosím, zadejte jej znovu.");
                telefonniCislo = kontrolaCisla();
            }
        }
    }
    
    // Metoda pro výpis velkého titulku aplikace při startu a běhu aplikace
    public void vypisTitulkuPojistovny() {
        System.out.println("------------------------------");
        System.out.println("Evidence pojištěných osob");
        System.out.println("------------------------------");
        System.out.println();
    }
    
    // Metoda pro výpis akcí aplikace, které může uživatel provádět
    public void vypisAkciPojistovny() {
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Ukončení aplikace");
        System.out.println();
    }
    
    /* Metoda pro výpis nadpisu pojištěnců (ve formátu Příjmení Jméno Věk Telefon), při dotazu na výpis všech
    pojištěnců uložených v databázi nebo pouze jednoho konkrétního*/
    public void vypisNadpisuPojistencu() {
        int znakyString = 20;
        int znakyInt = 10;
        String prijmeni = "PŘÍJMENÍ";
        String jmeno = "JMÉNO";
        String vek = "VĚK";
        String telefonniCislo = "TELEFONNÍ ČÍSLO";
        int dopocetZnakuPrijmeni = znakyString - prijmeni.length();
        int dopocetZnakuJmeno = znakyString - jmeno.length();
        int dopocetZnakuVek = znakyInt - vek.length();
        int[] dopocty = {dopocetZnakuPrijmeni, dopocetZnakuJmeno, dopocetZnakuVek};
        String mezeryPrijmeni = "";
        String mezeryJmeno = "";
        String mezeryVek = "";
        int maxZnaku = dopocty[0];
        for (int i = 1; i < dopocty.length; i++) {
            if (dopocty[i] > maxZnaku) {
                maxZnaku = dopocty[i];
            }
        }
        for (int i = 0; i < maxZnaku; i++) {
            if (i < dopocetZnakuPrijmeni) {
                mezeryPrijmeni += " ";
            }
            if (i < dopocetZnakuJmeno) {
                mezeryJmeno += " ";
            }
            if (i < dopocetZnakuVek) {
                mezeryVek += " ";
            }
        }
        System.out.println(prijmeni + mezeryPrijmeni + jmeno + mezeryJmeno + vek + mezeryVek + telefonniCislo);
    }
}