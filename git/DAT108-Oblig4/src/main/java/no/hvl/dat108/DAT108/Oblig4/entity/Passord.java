package no.hvl.dat108.DAT108.Oblig4.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Passord {
	private String hash;
	private String salt;

	public Passord() {
		hash = null;
		salt = null;
	}
	
	public Passord(String hash, String salt) {
		this.hash = hash;
		this.salt = salt;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	

}
