package de.thorstendiekhof.kurs.unittesting.newauslagern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Schredder {

	public void schredder(String daten) {
        List<Character> geschredderteDaten = new ArrayList<Character>();
        for (char c : daten.toCharArray())
        geschredderteDaten.add(c);
        Collections.shuffle(geschredderteDaten);
        for (Character c : geschredderteDaten) {
            System.out.println(c);
        }
	}

}