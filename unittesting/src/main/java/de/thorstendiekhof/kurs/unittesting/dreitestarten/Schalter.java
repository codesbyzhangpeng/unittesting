package de.thorstendiekhof.kurs.unittesting.dreitestarten;

public class Schalter {

    private Licht licht;

    public Schalter(Licht licht){
        this.licht = licht;
    }

    public void schalteLicht(){
        if(licht.isAn())
            licht.schalteAus();
        else
            licht.schalteAn();
    }
}