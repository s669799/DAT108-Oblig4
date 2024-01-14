package no.hvl.dat108.DAT108.Oblig4.utils;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;

@Service
public class LoginUtil {
	
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {
		loggUtBruker(request.getSession());
		HttpSession sesjon = request.getSession();
		sesjon.setMaxInactiveInterval(10); // sekunder før utlogging
		sesjon.setAttribute("bruker", deltager);
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		return session != null 
				&& session.getAttribute("mobil") != null 
				&& session.getAttribute("passord") != null;
		
	}

}
