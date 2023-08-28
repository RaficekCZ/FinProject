package cz.itnetwork.evidencepojistenych;

import java.util.ArrayList;

public class DatabazePojistencu {

    // Atribut ArrayList slouží k ukládání nových pojištěnců
    private ArrayList<Pojistenec> seznamPojistencu;
    
    // Inicializace ArrayListu v konstruktoru třídy
    public DatabazePojistencu() {
        seznamPojistencu = new ArrayList<>();
    }
    
    // Metoda pro založní nového pojištěncě
    public void zalozPojistence(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        seznamPojistencu.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
    }
    
    /* Metoda pro vyhledání konkrétního pojištěnce
    Může se stát, že pojištěnců se stejným jménem bude víc => ArrayList */
    public ArrayList<Pojistenec> vyhledejDanehoPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenec> pojisteneci = new ArrayList<>();
        for (Pojistenec pojistenec : seznamPojistencu) {
            if (jmeno.equals(pojistenec.getJmeno()) && prijmeni.equals(pojistenec.getPrijmeni())) {
                pojisteneci.add(pojistenec);
            }
        }
        return pojisteneci;
    }
    
    // Metoda pro navrácení celého seznamu všech pojistěnců (vyhledání všech pojištěnců)
    public ArrayList<Pojistenec> vyhledejVsechnyPojistence() {
        return seznamPojistencu;
    }
}