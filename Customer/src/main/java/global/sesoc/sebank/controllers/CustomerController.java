package global.sesoc.sebank.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.sebank.repository.CustomerRepository;
import global.sesoc.sebank.vo.Customer;

@Controller
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
		return "customer/alert";
	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck() {
		return "customer/idCheck";
	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public String idCheck(String custid, Model model) {
		model.addAttribute("id", custid);
		model.addAttribute("check", true);
		if (cr.idCheck(custid) != null) {
			model.addAttribute("id", null);
		}
		return "customer/idCheck";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "customer/loginForm";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Customer customer) {
		HttpSession session = request.getSession();
		Customer cu = cr.login(customer);
		if (cu == null) {
			model.addAttribute("message", "로그인 실패!");
			model.addAttribute("url", "login");
		} else {
			session.setAttribute("loginId", cu.getCustid());
			session.setAttribute("loginName", cu.getName());
			model.addAttribute("message", "환영합니다!");
		}
		return "customer/alert";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model, Customer customer) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("message", "로그아웃 하셨습니다.");
		return "customer/alert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
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
