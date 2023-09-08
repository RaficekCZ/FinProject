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
public class PojisteniService {

    public void zalozitNovePojisteni(PojisteniDTO DTO){
        String nazev = DTO.getNazev();
        String min = DTO.getMin();
        String max = DTO.getMax();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO pojisteni (nazev, min, max) VALUES (?, ?, ?)");
            dotaz.setString(1, nazev);
            dotaz.setString(2, min);
            dotaz.setString(3, max);
            dotaz.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
    }
    
    /* 
        Toto možná není nejlepší řešení, protože při každém kliku na záložku "Pojištění", se generuje nová instance každého pojištění.
        Zatím jsem ale nepřišel na způsob, jak toto provést lépe.
    */    
    public List<PojisteniDTO> ziskaniVsechPojisteni() {
        List<PojisteniDTO> pojisteni = new ArrayList<>();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojisteni");
            ResultSet vysledky = dotaz.executeQuery();
            
            while (vysledky.next()) {
                pojisteni.add(new PojisteniDTO(vysledky.getString(2), vysledky.getString(3), vysledky.getString(4)));
            }
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }      
        return pojisteni;
    }    

}