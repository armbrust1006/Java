package global.sesoc.sebank.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import global.sesoc.sebank.repository.CustomerRepository;
import global.sesoc.sebank.vo.Customer;

@Controller
@RequestMapping("customer")
@SessionAttributes("customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

	@Autowired
	CustomerRepository cr;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "customer/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, Customer customer) {
		cr.insert(customer);
		model.addAttribute("message", "회원가입을 환영합니다!");
		return "redirect:/";
	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck() {
		return "customer/idCheck";
	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public String idCheck(String custid, Model model) {
		model.addAttribute("id", custid);
		model.addAttribute("check", true);
		if (cr.idCheck(custid) == null) {
			model.addAttribute("choice", true);
		}
		return "customer/idCheck";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "customer/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, Customer customer) {
		Customer cu = cr.login(customer);
		if (cu == null) {
			model.addAttribute("errorMsg", "ID 또는 비밀번호가 틀립니다.");
			return "customer/loginForm";
		} else {
			session.setAttribute("loginId", cu.getCustid());
			session.setAttribute("loginName", cu.getName());
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model, Customer customer) {
		session.invalidate();
		model.addAttribute("errorMsg", "로그아웃 하셨습니다.");
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		model.addAttribute("customer", cr.updateSelect((String) session.getAttribute("loginId")));
		return "customer/updateForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Customer customer, Model model) {
		if (cr.update(customer) == 1) {
			model.addAttribute("message", "수정 성공!");
		} else {
			model.addAttribute("message", "수정 실패!");
		}
		return "customer/alert";
	}
}
