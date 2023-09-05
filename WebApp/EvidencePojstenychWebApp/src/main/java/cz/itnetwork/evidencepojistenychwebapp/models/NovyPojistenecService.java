package cz.itnetwork.evidencepojistenychwebapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class NovyPojistenecService {

    public void zalozitNovehoPojistence(NovyPojistenecDTO novyPojistenec){
        String jmeno = novyPojistenec.getJmeno();
        String prijmeni = novyPojistenec.getPrijmeni();
        String email = novyPojistenec.getEmail();
        String telefon = novyPojistenec.getTelefon();
        String uliceCislo = novyPojistenec.getUliceCislo();
        String mesto = novyPojistenec.getMesto();
        String psc = novyPojistenec.getPsc();
        System.out.println(jmeno);
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/slovnicek_db?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO slovo (jmeno, prijmeni, email, telefon, ulice_cislo, mesto, psc) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
}