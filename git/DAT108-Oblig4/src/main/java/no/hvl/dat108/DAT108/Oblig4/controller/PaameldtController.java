package no.hvl.dat108.DAT108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.utils.LoginUtil;

@Controller
public class PaameldtController {

	@Autowired
	private LoginUtil loginUtil;

	@GetMapping("/paameldt")
	public String getPaameldt(HttpSession session) {

		return "paameldt";
	}

	@PostMapping("/deltagere")
	public String getDeltagerliste(@ModelAttribute Deltager deltager, HttpSession session, HttpServletRequest request) {
		if (LoginUtil.erBrukerInnlogget(session)) {
			session.setAttribute("bruker", deltager);
			return "redirect:deltagerliste";
		}
		return "redirect:innlogging";

	}

}
