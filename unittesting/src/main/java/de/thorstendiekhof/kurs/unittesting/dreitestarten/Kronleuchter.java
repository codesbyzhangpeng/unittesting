package de.thorstendiekhof.kurs.unittesting.dreitestarten;

public class Kronleuchter implements Licht{

    private boolean an = false;

	@Override
	public boolean isAn() {
		return an;
	}

	@Override
	public void schalteAus() {
        	this.an = false;
        	System.out.println("Der Kronleuchter geht aus.");
	}

	@Override
	public void schalteAn() {
        	this.an = true;
        	System.out.println("Der Kronleuchter erstrahlt in güldenem Glanze!");
	}
}