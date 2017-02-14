package global.sesoc.sebank.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.sebank.vo.Customer;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		return "joinFomr";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Customer customer) {
		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Customer customer) {
		return "redirect:/";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(Customer customer) {
		return "redirect:/";
	}
}
