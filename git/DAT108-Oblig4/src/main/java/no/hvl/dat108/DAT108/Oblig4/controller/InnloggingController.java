package no.hvl.dat108.DAT108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.service.DeltagerService;
import no.hvl.dat108.DAT108.Oblig4.utils.InputValidator;
import no.hvl.dat108.DAT108.Oblig4.utils.LoginUtil;

@Controller
@RequestMapping("/innlogging")
public class InnloggingController {

	@Autowired
	private DeltagerService deltagerService;

	@GetMapping
	public String innlogging() {
		return "innlogging_med_melding";
	}

	@PostMapping
	public String provAaLoggeInn(@RequestParam String mobil, String passord, HttpServletRequest request,
			RedirectAttributes ra, HttpSession session) {

		if (!InputValidator.erGyldigBrukernavn(mobil) || !InputValidator.erGyldigPassord(passord)) {
			ra.addFlashAttribute("redirectMessage", "Ugyldig");
			return "redirect:innlogging";
		}
		Deltager bruker = deltagerService.finnDeltagerMedId(mobil);
		if (deltagerService.sjekkPassord(request, bruker, passord)) {
			LoginUtil.loggInnBruker(request, bruker);
			return "redirect:deltagerliste";

		} else {
			ra.addFlashAttribute("redirectMessage", "Ugyldig");
			return "redirect:innlogging";
		}

	}

}