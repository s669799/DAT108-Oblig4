package no.hvl.dat108.DAT108.Oblig4.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegInput {

	@Pattern(regexp = "\\d{8}")
	private String mobil;

	@Pattern(regexp = "^[A-ZÆØÅa-zæøå0-9]{3,20}$")
	private String passord;

	@Size(min = 2, max = 20, message = "Navn må være mellom 2 og 20 tegn")
	@Pattern(regexp = "^[A-ZÆØÅ][a-zæøå]+(?:[- ][A-Z][a-zæøå]+)*?$")
	private String fornavn;

	@Size(min = 2, max = 20, message = "Navn må være mellom 2 og 20 tegn")
	@Pattern(regexp = "^[A-ZÆØÅ][a-zæøå]+(-[A-Z][a-zæøå]+)*?$")
	private String etternavn;

	@Pattern(regexp = "^(mann|kvinne)$")
	private String kjonn;

	public RegInput() {
		super();
	}

	public RegInput(String mobil, String passord, String fornavn, String etternavn, String kjonn) {
		this.mobil = mobil;
		this.passord = passord;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;

	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjonn=" + kjonn
				+ "]";
	}

}
