package cz.itnetwork.evidencepojistenychwebapp.models;

import org.springframework.stereotype.Service;

@Service
public class PrihlaseniService {

    public String vypis(PrihlaseniDTO prihlaseni){
        return prihlaseni.getJmeno();
    }
}