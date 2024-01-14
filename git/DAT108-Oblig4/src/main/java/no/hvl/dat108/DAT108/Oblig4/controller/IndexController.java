package no.hvl.dat108.DAT108.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	public String index() {
		return "index";
	}

}
