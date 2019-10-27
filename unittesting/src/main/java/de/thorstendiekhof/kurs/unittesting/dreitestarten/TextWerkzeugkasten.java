package de.thorstendiekhof.kurs.unittesting.dreitestarten;

public class TextWerkzeugkasten {

    public String ersetzeLeerzeichen(String text, String trenner){
        return text.replaceAll(" ", trenner);
    }
    
}