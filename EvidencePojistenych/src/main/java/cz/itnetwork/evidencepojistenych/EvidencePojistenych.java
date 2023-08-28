package cz.itnetwork.evidencepojistenych;

import java.util.Scanner;

public class EvidencePojistenych {

    public static void main(String[] args) {
        // Založení potřebných instancí
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Pojistovna pojistovna = new Pojistovna();
        String uzivatelskaVolba = "";
        
        // Hlavní smyčka celého programu
        while (!uzivatelskaVolba.equals("4")) {
            pojistovna.vypisTitulkuPojistovny();
            pojistovna.vypisAkciPojistovny();
            uzivatelskaVolba = sc.nextLine();
            System.out.println();
            
            switch (uzivatelskaVolba) {
                case "1":
                    pojistovna.zalozPojistence();
                    break;
                case "2":
                    pojistovna.vypisVsechnyPojistence();
                    break;
                case "3":
                    pojistovna.vypisDanehoPojistence();
                case "4":
                    break;
                default:
                    System.out.println("Neplatná volba. Prosím, zvolte znovu.");
                    break;
            }
        }
        System.out.println("Děkujeme za využítí softwaru PojistovnaStesti(v1.05). Budeme se těšit na Vaše další použití!");
    }
}