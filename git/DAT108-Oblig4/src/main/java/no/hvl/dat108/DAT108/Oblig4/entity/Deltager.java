package no.hvl.dat108.DAT108.Oblig4.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "deltager")
public class Deltager {
	@Id
	private String mobil;
	@Embedded
	private Passord passord;
	private String fornavn;
	private String etternavn;
	private String kjonn;
	
	
	public Deltager() {
		mobil = null;
		passord = null;
		fornavn = null;
		etternavn = null;
		kjonn = null;
	}

	public Deltager(RegInput input, Passord passord) {
		this.mobil = input.getMobil();
		this.passord = passord;
		this.fornavn = input.getFornavn();
		this.etternavn = input.getEtternavn();
		this.kjonn = input.getKjonn();
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
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
		return "Deltager [mobil=" + mobil + ", passord=" + passord + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", kjonn=" + kjonn + "]";
	}
	

}
