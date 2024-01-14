package no.hvl.dat108.DAT108.Oblig4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.entity.RegInput;

class InputValideringTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	public void gyldigMobil() {

		RegInput input = new RegInput("12345678", "pass", "Per", "Persen", "mann");

		assertTrue(erGyldigEgenskap(input, "mobil"));
		assertTrue(erGyldigEgenskap(input, "fornavn"));
		assertTrue(erGyldigEgenskap(input, "etternavn"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "123456", "12345678910", "123456789" })
	public void ugyldigMobil(String mobilFraListe) {

		RegInput input = new RegInput(mobilFraListe, "pass", "Per", "Persen", "mann");
		assertFalse(erGyldigEgenskap(input, "mobil"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "11223344", "12345678", "12344321", "55667788" })
	public void gyldigMobil(String mobilFraListe) {

		RegInput input = new RegInput(mobilFraListe, "pass", "Per", "Persen", "mann");
		assertTrue(erGyldigEgenskap(input, "mobil"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "-Pelle", "P", "petter", "Per  Pelle", "Frank--Roger", "Per-",
			"Tjueenbokstaverherane" })
	public void ugyldigFornavn(String fornavnFraListe) {

		RegInput input = new RegInput("11223344", "pass", fornavnFraListe, "Persen", "mann");
		assertFalse(erGyldigEgenskap(input, "fornavn"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Bob Roger", "Kent-Roger", "Per", "Børge", "Jo", "Tjuebokstaverinavnet" })
	public void gyldigFornavn(String fornavnFraListe) {

		RegInput input = new RegInput("11223344", "pass", fornavnFraListe, "Persen", "mann");
		assertTrue(erGyldigEgenskap(input, "fornavn"));
	}

	private boolean erGyldigEgenskap(RegInput input, String egenskap) {

		return !validator.validate(input).stream()
				.map(v -> v.getPropertyPath().toString())
				.collect(Collectors.toSet())
				.contains(egenskap);
	}
}