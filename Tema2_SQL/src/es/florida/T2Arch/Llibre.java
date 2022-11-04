package es.florida.T2Arch;

import java.time.Year;

public class Llibre {
	
String titol;

String autor;

String ant_nac;

String any_public;

String editiorial;

String numpag;

public Llibre(String titol, String autor, String ant_nac, String any_public, String editiorial, String numpag) {
	super();
	this.titol = titol;
	this.autor = autor;
	this.ant_nac = ant_nac;
	this.any_public = any_public;
	this.editiorial = editiorial;
	this.numpag = numpag;
}

public String getTitol() {
	return titol;
}

public String getAutor() {
	return autor;
}

public String getAnt_nac() {
	return ant_nac;
}

public String getAny_public() {
	return any_public;
}

public String getEditiorial() {
	return editiorial;
}

public String getNumpag() {
	return numpag;
}





}
