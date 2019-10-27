package de.thorstendiekhof.kurs.unittesting.uebungen.langekerls;

public class Rekrutierungsbuero {

    public TruppenGattung muster(Rekrut rekrut){
        if(rekrut.isAdelig())
            return TruppenGattung.OFFIZIER;
        if(rekrut.isSehrGross())
            return TruppenGattung.LANGE_KERLS;
        if(rekrut.isKlug()){
            if(rekrut.isKlein())
                return TruppenGattung.ARTILLERIE;
            if(!rekrut.isSeekrank())
                return TruppenGattung.MARINE;
        }
        if(rekrut.isDick())
            return TruppenGattung.VERSORGUNG;
        if(rekrut.isGross())
            return TruppenGattung.GARDE;
        if(rekrut.isStadtbewohner())
            return TruppenGattung.REITERTRUPPE;
        return TruppenGattung.INFANTERIE;
        
    }
}