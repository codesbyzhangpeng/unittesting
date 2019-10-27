package de.thorstendiekhof.kurs.unittesting.uebungen.langekerls;

public class Rekrut {

    private int koerpergroesseInCm;
    private int gewichtInKg;
    private boolean schulabschluss;
    private boolean stadtbewohner;
    private boolean adel;
    private boolean seekrank;

    public Rekrut(int koerpergroesseInCm, int gewichtInKg){
        this.koerpergroesseInCm = koerpergroesseInCm;
        this.gewichtInKg = gewichtInKg;
    }

    public Rekrut mitSchulabschluss(){
        this.schulabschluss = true;
        return this;
    }

    public Rekrut istStadtbewohner(){
        this.stadtbewohner = true;
        return this;
    }

    public Rekrut istAdelig(){
        this.adel = true;
        return this;
    }

    public Rekrut wirdSeekrank(){
        this.seekrank = true;
        return this;
    }

	public boolean isAdelig() {
		return adel;
    }

    public boolean isSeekrank(){
        return seekrank;
    }

    public boolean isStadtbewohner(){
        return stadtbewohner;
    }

    public boolean isKlug(){
        return schulabschluss;
    }

    public boolean isGross(){
        return koerpergroesseInCm > 175 ? true : false;
    }

    public boolean isSehrGross(){
        return koerpergroesseInCm > 185 ? true : false;
    }

    public boolean isKlein(){
        return koerpergroesseInCm < 160 ? true : false;
    }

    public boolean isDick(){
        if(berechneBMI() > 25)
            return true;
        return false;
    }

    private double berechneBMI(){
        double koerpergroesseInM = (double) koerpergroesseInCm / 100;
        double bmi = gewichtInKg / Math.pow(koerpergroesseInM, 2);
        return bmi;
    }

}