package cz.itnetwork.evidencepojistenychwebapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PojistenecService {

    public void zalozitNovehoPojistence(PojistenecDTO pojistenec){
        String jmeno = pojistenec.getJmeno();
        String prijmeni = pojistenec.getPrijmeni();
        String email = pojistenec.getEmail();
        String telefon = pojistenec.getTelefon();
        String uliceCislo = pojistenec.getUliceCislo();
        String mesto = pojistenec.getMesto();
        String psc = pojistenec.getPsc();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO pojistenci (jmeno, prijmeni, email, telefon, ulice_cislo, mesto, psc) VALUES (?, ?, ?, ?, ?, ?, ?)");
            dotaz.setString(1, jmeno);
            dotaz.setString(2, prijmeni);
            dotaz.setString(3, email);
            dotaz.setString(4, telefon);
            dotaz.setString(5, uliceCislo);
            dotaz.setString(6, mesto);
            dotaz.setString(7, psc);
            dotaz.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
    }
    
    public List<PojistenecDTO> ziskaniVsechPojistencu() {
        List<PojistenecDTO> pojistenci = new ArrayList<>();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci");
            ResultSet vysledky = dotaz.executeQuery();
            
            while (vysledky.next()) {
                pojistenci.add(new PojistenecDTO(vysledky.getString(2), vysledky.getString(3), vysledky.getString(4), vysledky.getString(5),
                                                 vysledky.getString(6), vysledky.getString(7), vysledky.getString(8)));
            }
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }      
        return pojistenci;
    }
}