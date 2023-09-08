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
    
    public void zalozitNovehoPojistence(PojistenecDTO pojistenecDTO){
        String jmeno = pojistenecDTO.getJmeno();
        String prijmeni = pojistenecDTO.getPrijmeni();
        String email = pojistenecDTO.getEmail();
        String telefon = pojistenecDTO.getTelefon();
        String uliceCislo = pojistenecDTO.getUliceCislo();
        String mesto = pojistenecDTO.getMesto();
        String psc = pojistenecDTO.getPsc();
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
    
    /* 
        Toto možná není nejlepší řešení, protože při každém kliku na záložku "Pojištěnci", se generuje nová instance každého pojištěnce.
        Zatím jsem ale nepřišel na způsob, jak toto provést lépe.
    */
    public List<PojistenecDTO> ziskaniVsechPojistencu() {
        List<PojistenecDTO> pojistenci = new ArrayList<>();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci");
            ResultSet vysledky = dotaz.executeQuery();
            
            while (vysledky.next()) {
                pojistenci.add(new PojistenecDTO(vysledky.getInt(1), vysledky.getString(2), vysledky.getString(3), vysledky.getString(4),
                                                 vysledky.getString(5), vysledky.getString(6), vysledky.getString(7), vysledky.getString(8)));
            }
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }      
        return pojistenci;
    }
    
    public PojistenecDTO ziskatDetailPojistence(String id) {
        PojistenecDTO pojistenecDTO = null;
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci WHERE pojistenci_id = ?");
            dotaz.setString(1, id);
            ResultSet vysledky = dotaz.executeQuery();
            vysledky.next();
            pojistenecDTO = new PojistenecDTO(vysledky.getInt(1), vysledky.getString(2), vysledky.getString(3), vysledky.getString(4),
                                              vysledky.getString(5), vysledky.getString(6), vysledky.getString(7), vysledky.getString(8));
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
        return pojistenecDTO;
    }    
}