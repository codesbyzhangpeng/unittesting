package de.thorstendiekhof.kurs.unittesting.integration.modulA;

import java.io.File;

public class ModulA {

    private ModulB modulB;

    public ModulA(ModulB modulB){
        this.modulB = modulB;
    }

    public void machWas(DatenklasseA datenklasseA){
        datenklasseA.zahl ++;
        datenklasseA.entscheidung = !datenklasseA.entscheidung;

        modulB.save(datenklasseA);
    }

    public DatenklasseA zeigHer(String text){
        DatenklasseA daten = modulB.load(text);
        return daten;
    }

    
}