package no.hvl.dat108.DAT108.Oblig4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.service.DeltagerService;
import no.hvl.dat108.DAT108.Oblig4.utils.LoginUtil;

@Controller
public class DeltagerlisteController {

	@Autowired
	private LoginUtil loginUtil;
	@Autowired
	private DeltagerService deltagerService;

	@GetMapping("/deltagerliste")
	public String getDeltagerliste(HttpSession session, Model model1, Model model2, RedirectAttributes ra) {
		List<Deltager> deltagere = deltagerService.finnAlleDeltagere();
		Deltager bruker  = (Deltager) session.getAttribute("bruker");
		model1.addAttribute("deltagere", deltagere);
		model2.addAttribute("bruker", bruker);
		
		return "deltagerliste";
	}

	@PostMapping("/utlogging")
	public String loggUt(HttpSession session) {
		if (loginUtil.erBrukerInnlogget(session)) {
			loginUtil.loggUtBruker(session);
		}
		return "redirect:";
	}
}
