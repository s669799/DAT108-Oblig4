package no.hvl.dat108.DAT108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;
import no.hvl.dat108.DAT108.Oblig4.entity.RegInput;
import no.hvl.dat108.DAT108.Oblig4.service.DeltagerService;
import no.hvl.dat108.DAT108.Oblig4.utils.LoginUtil;

@Controller
@RequestMapping("/paamelding")
public class PaameldingController {

	@Autowired
	private LoginUtil loginUtil;

	@Autowired
	private DeltagerService deltagerService;

	@GetMapping
	public String paamelding() {
		return "paamelding_med_melding";
	}

	@PostMapping
	public String registrerDeltager(@Valid @ModelAttribute RegInput input, BindingResult bindingResult,
			RedirectAttributes ra, HttpServletRequest request, HttpSession session, Model model) {

		if (bindingResult.hasErrors()) {
			String feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
					.reduce("", (e, f) -> e + f + "<br>");
			model.addAttribute("feilmeldinger", feilmeldinger);
			System.err.println(input.toString());
			System.err.println(feilmeldinger);
			ra.addFlashAttribute("input", input);
			return "redirect:paamelding";
		}

		Deltager deltager = new Deltager(input, deltagerService.krypterPassord(input.getPassord()));

		System.out.println(deltager.toString());
		ra.addFlashAttribute("deltager", deltager);
		deltagerService.lagreDeltager(deltager);
		LoginUtil.loggInnBruker(request, deltager);
		return "redirect:paameldt";
	}
}
