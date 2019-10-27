package de.thorstendiekhof.kurs.unittesting.newauslagern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Datenbank {

    Map<String,String> datenbank = new HashMap<String,String>();

    public String save(String daten){
        String id = UUID.randomUUID().toString();
        datenbank.put(id, daten);
        return id;
    }

    public String load(String id){
        return datenbank.get(id);
    }

    public List<String> search(String searchString){
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String,String> entry : datenbank.entrySet()) {
            if(entry.getValue().contains(searchString))
                result.add(entry.getValue());
        }
        return result;
    }
}