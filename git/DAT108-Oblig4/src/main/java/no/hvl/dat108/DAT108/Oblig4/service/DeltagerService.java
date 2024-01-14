package no.hvl.dat108.DAT108.Oblig4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.entity.Passord;
import no.hvl.dat108.DAT108.Oblig4.repo.DeltagerRepo;

@Service
public class DeltagerService {

	@Autowired
	private DeltagerRepo deltagerRepo;
	@Autowired
	private PassordService passordService;

	public Passord krypterPassord(String passordKlartekst) {
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(passordKlartekst, salt);
		Passord passord = new Passord(hash, salt);
		return passord;
	}

	public boolean sjekkPassord(HttpServletRequest request, Deltager deltager, String passord) {
		return (passordService.erKorrektPassord(passord, deltager.getPassord().getSalt(),
				deltager.getPassord().getHash())) ? true : false;
	}

	public void lagreDeltager(Deltager deltager) {
		deltagerRepo.save(deltager);
	}

	public void slettDeltager(Deltager deltager) {
		deltagerRepo.delete(deltager);
	}

	public void slettAlleDeltagere() {
		deltagerRepo.deleteAll();
	}

	public List<Deltager> finnAlleDeltagere() {
		return deltagerRepo.findAll();
	}

	public Deltager finnDeltagerMedId(String id) {
		return deltagerRepo.findById(Integer.parseInt(id)).orElseThrow();
	}
}
