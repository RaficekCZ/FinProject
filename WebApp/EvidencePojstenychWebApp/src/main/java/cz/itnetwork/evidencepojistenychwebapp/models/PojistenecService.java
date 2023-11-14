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
    
    public void zalozitPojistence(PojistenecDTO pojistenecDTO){
        PojistenecEntity pojistenec = new PojistenecEntity();
        pojistenec.setJmeno(pojistenecDTO.getJmeno());
        pojistenec.setPrijmeni(pojistenecDTO.getPrijmeni());
        pojistenec.setEmail(pojistenecDTO.getEmail());
        pojistenec.setTelefon(pojistenecDTO.getTelefon());
        pojistenec.setUliceCislo(pojistenecDTO.getUliceCislo());
        pojistenec.setMesto(pojistenecDTO.getMesto());
        pojistenec.setPsc(pojistenecDTO.getPsc());
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO pojistenci (jmeno, prijmeni, email, telefon, ulice_cislo, mesto, psc) VALUES (?, ?, ?, ?, ?, ?, ?)");
            dotaz.setString(1, pojistenec.getJmeno());
            dotaz.setString(2, pojistenec.getPrijmeni());
            dotaz.setString(3, pojistenec.getEmail());
            dotaz.setString(4, pojistenec.getTelefon());
            dotaz.setString(5, pojistenec.getUliceCislo());
            dotaz.setString(6, pojistenec.getMesto());
            dotaz.setString(7, pojistenec.getPsc());
            dotaz.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
    }

    public List<PojistenecDTO> ziskatVsechnyPojistence() {
        List<PojistenecEntity> seznamPojistencuEntity = new ArrayList<>();
        List<PojistenecDTO> seznamPojistencuDTO = new ArrayList<>();
        int counter = 0;
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci");
            ResultSet vysledky = dotaz.executeQuery();
            while (vysledky.next()) {
                PojistenecEntity pojistenecEntity = new PojistenecEntity();
                PojistenecDTO pojistenecDTO = new PojistenecDTO();
                seznamPojistencuEntity.add(pojistenecEntity);
                seznamPojistencuDTO.add(pojistenecDTO);
                seznamPojistencuEntity.get(counter).setPojistenecId(vysledky.getInt(1));
                seznamPojistencuDTO.get(counter).setPojistenecId(seznamPojistencuEntity.get(counter).getPojistenecId());
                seznamPojistencuEntity.get(counter).setJmeno(vysledky.getString(2));
                seznamPojistencuDTO.get(counter).setJmeno(seznamPojistencuEntity.get(counter).getJmeno());
                seznamPojistencuEntity.get(counter).setPrijmeni(vysledky.getString(3));
                seznamPojistencuDTO.get(counter).setPrijmeni(seznamPojistencuEntity.get(counter).getPrijmeni());
                seznamPojistencuEntity.get(counter).setEmail(vysledky.getString(4));
                seznamPojistencuDTO.get(counter).setEmail(seznamPojistencuEntity.get(counter).getEmail());
                seznamPojistencuEntity.get(counter).setTelefon(vysledky.getString(5));
                seznamPojistencuDTO.get(counter).setTelefon(seznamPojistencuEntity.get(counter).getTelefon());
                seznamPojistencuEntity.get(counter).setUliceCislo(vysledky.getString(6));
                seznamPojistencuDTO.get(counter).setUliceCislo(seznamPojistencuEntity.get(counter).getUliceCislo());
                seznamPojistencuEntity.get(counter).setMesto(vysledky.getString(7));
                seznamPojistencuDTO.get(counter).setMesto(seznamPojistencuEntity.get(counter).getMesto());
                seznamPojistencuEntity.get(counter).setPsc(vysledky.getString(8));
                seznamPojistencuDTO.get(counter).setPsc(seznamPojistencuEntity.get(counter).getPsc());
                seznamPojistencuDTO.get(counter).setCeleJmeno(seznamPojistencuDTO.get(counter).getJmeno() + " " + seznamPojistencuDTO.get(counter).getPrijmeni());
                seznamPojistencuDTO.get(counter).setAdresa(seznamPojistencuDTO.get(counter).getUliceCislo() + ", " + seznamPojistencuDTO.get(counter).getMesto() + ", " + seznamPojistencuDTO.get(counter).getPsc());
                counter++;
            }
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
        return seznamPojistencuDTO;
    }
    
    public PojistenecDTO ziskatDetailPojistence(String id) {
        PojistenecEntity pojistenecEntity = new PojistenecEntity();
        PojistenecDTO pojistenecDTO = new PojistenecDTO();
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci WHERE pojistenci_id = ?");
            dotaz.setString(1, id);
            ResultSet vysledky = dotaz.executeQuery();
            vysledky.next();
            pojistenecEntity.setPojistenecId(vysledky.getInt(1));
            pojistenecDTO.setPojistenecId(pojistenecEntity.getPojistenecId());
            pojistenecEntity.setJmeno(vysledky.getString(2));
            pojistenecDTO.setJmeno(pojistenecEntity.getJmeno());
            pojistenecEntity.setPrijmeni(vysledky.getString(3));
            pojistenecDTO.setPrijmeni(pojistenecEntity.getPrijmeni());
            pojistenecEntity.setEmail(vysledky.getString(4));
            pojistenecDTO.setEmail(pojistenecEntity.getEmail());
            pojistenecEntity.setTelefon(vysledky.getString(5));
            pojistenecDTO.setTelefon(pojistenecEntity.getTelefon());
            pojistenecEntity.setUliceCislo(vysledky.getString(6));
            pojistenecDTO.setUliceCislo(pojistenecEntity.getUliceCislo());
            pojistenecEntity.setMesto(vysledky.getString(7));
            pojistenecDTO.setMesto(pojistenecEntity.getMesto());
            pojistenecEntity.setPsc(vysledky.getString(8));
            pojistenecDTO.setPsc(pojistenecEntity.getPsc());
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
        return pojistenecDTO;
    }

    public void editovatPojistence(PojistenecDTO pojistenecDTO){
        PojistenecEntity pojistenec = new PojistenecEntity();
        pojistenec.setPojistenecId(pojistenecDTO.getPojistenecId());
        pojistenec.setJmeno(pojistenecDTO.getJmeno());
        pojistenec.setPrijmeni(pojistenecDTO.getPrijmeni());
        pojistenec.setEmail(pojistenecDTO.getEmail());
        pojistenec.setTelefon(pojistenecDTO.getTelefon());
        pojistenec.setUliceCislo(pojistenecDTO.getUliceCislo());
        pojistenec.setMesto(pojistenecDTO.getMesto());
        pojistenec.setPsc(pojistenecDTO.getPsc());
        try {
            Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistovna?user=root&password=");
            //PreparedStatement dotaz = spojeni.prepareStatement("UPDATE pojistenci SET jmeno = sdf, `prijmeni` = 'fdsf', `email` = 'fsdf' WHERE `pojistenci_id` = 1");
            PreparedStatement dotaz = spojeni.prepareStatement("UPDATE pojistenci SET jmeno = ?, prijmeni = ?, email = ?, telefon = ?, ulice_cislo = ?, mesto = ?, psc = ? WHERE pojistenci_id = ?");
            dotaz.setString(1, pojistenec.getJmeno());
            dotaz.setString(2, pojistenec.getPrijmeni());
            dotaz.setString(3, pojistenec.getEmail());
            dotaz.setString(4, pojistenec.getTelefon());
            dotaz.setString(5, pojistenec.getUliceCislo());
            dotaz.setString(6, pojistenec.getMesto());
            dotaz.setString(7, pojistenec.getPsc());
            dotaz.setString(8, Integer.toString(pojistenec.getPojistenecId()));
            dotaz.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Chyba při komunikaci s databází");
        }
    }
    
    //Dodělat tělo smazání - tohle je založeno pouze pro zavolání funkce jinde
    public void smazatPojistence(PojistenecDTO pojistenecDTO){
        System.out.println(pojistenecDTO.getJmeno());
    } 
}