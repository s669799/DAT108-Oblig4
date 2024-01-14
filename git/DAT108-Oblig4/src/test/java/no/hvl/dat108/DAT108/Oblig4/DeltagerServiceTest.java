package no.hvl.dat108.DAT108.Oblig4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.entity.Passord;
import no.hvl.dat108.DAT108.Oblig4.entity.RegInput;
import no.hvl.dat108.DAT108.Oblig4.repo.DeltagerRepo;
import no.hvl.dat108.DAT108.Oblig4.service.DeltagerService;
import no.hvl.dat108.DAT108.Oblig4.service.PassordService;

@ExtendWith(MockitoExtension.class)
class DeltagerServiceTest {

	@Mock
	private DeltagerRepo mockedDeltagerRepo;

	@Mock
	private PassordService passordService;

	@InjectMocks
	private DeltagerService deltagerService;

	private List<Deltager> mockedList = List.of(
			new Deltager(new RegInput("11111111", "pass1", "fornavn1", "etternavn1", "mann"),
					new Passord("hash", "salt")),
			new Deltager(new RegInput("22222222", "pass2", "fornavn2", "etternavn2", "kvinne"),
					new Passord("hash", "salt")),
			new Deltager(new RegInput("33333333", "pass3", "fornavn3", "etternavn3", "mann"),
					new Passord("hash", "salt")),
			new Deltager(new RegInput("44444444", "pass4", "fornavn4", "etternavn4", "kvinne"),
					new Passord("hash", "salt")),
			new Deltager(new RegInput("55555555", "pass5", "fornavn5", "etternavn5", "mann"),
					new Passord("hash", "salt")),
			new Deltager(new RegInput("66666666", "pass6", "fornavn6", "etternavn6", "kvinne"),
					new Passord("hash", "salt")));

	@Test
	public void getAllParticipantsTest() {
		when(mockedDeltagerRepo.findAll()).thenReturn(mockedList);

		List<Deltager> resultat = deltagerService.finnAlleDeltagere();

		assertEquals(mockedList.size(), resultat.size());
		assertTrue(resultat.containsAll(mockedList));
	}

	@Test
	public void lagreDeltagerTest() {
		when(mockedDeltagerRepo.findAll()).thenReturn(mockedList);

		when(mockedDeltagerRepo.save(Mockito.any(Deltager.class))).thenAnswer(i -> i.getArgument(0));

		when(mockedDeltagerRepo.findById(Mockito.anyInt()))
				.then(i -> mockedList.stream().filter(p -> p.getMobil().equals("" + i.getArgument(0))).findAny());

		Deltager ny = new Deltager(new RegInput("77777777", "pass7", "fornavn7", "etternavn7", "mann"),
				new Passord("hash", "salt"));

		System.out.println(ny.toString());

		deltagerService.lagreDeltager(ny);

		Deltager resultat = deltagerService.finnDeltagerMedId("77777777");

		System.out.println(resultat.toString() + "\n");

		assertEquals(ny, resultat);
//		assertTrue(mockedList.contains("55555555"));
//		assertFalse(resultat.contains("88888888"));
	}

	@Test
	public void slettDeltagerTest() {

	}

	@Test
	public void finnDeltagerMedIdTest() {

		when(mockedDeltagerRepo.findById(Mockito.anyInt()))
				.then(i -> mockedList.stream().filter(p -> p.getMobil().equals("" + i.getArgument(0))).findAny());

		Deltager frank = new Deltager(new RegInput("22222222", "pass2", "fornavn2", "etternavn2", "kvinne"),
				new Passord("hash", "salt"));

		Deltager resultat = deltagerService.finnDeltagerMedId("22222222");

		assertTrue(mockedList.contains(resultat));
	}
}
