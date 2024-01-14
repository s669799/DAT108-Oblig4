package no.hvl.dat108.DAT108.Oblig4.utils;

public class InputValidator {

    public static final String MOBIL = "\\d{8}";
    public static final String PASSORD = "^[A-ZÆØÅa-zæøå0-9]{3,20}$";
   

    public static boolean erGyldigBrukernavn(String mobil) {
    	return mobil != null && mobil.matches(MOBIL);
    }
    public static boolean erGyldigPassord(String passord) {
    	return passord != null && passord.matches(PASSORD);
    }
}






