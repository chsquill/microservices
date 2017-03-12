package com.boot.web;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	protected Logger logger = Logger.getLogger(getClass().getName());

	@Value("${message}")
	private String message;

	@Autowired
	private WebAccountsService webAccountsService;

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		return "accounts";
	}

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@RequestMapping("/accounts")
	public String findAll(Model model) {
		logger.info("web-service findAll() invoked");
		List<Account> accounts = webAccountsService.findAll();
		model.addAttribute("accounts", accounts);
		return "accounts";
	}

	@RequestMapping("/accounts/number")
	public String findByNumber(Model model, @RequestParam(value = "accountNumber") String accountNumber) {
		logger.info("web-service byNumber() invoked: " + accountNumber);
		Account account = webAccountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + account);
		model.addAttribute("account", account);
		return "accounts";
	}

	@RequestMapping("/accounts/id")
	public String findById(Model model, @RequestParam(value = "accountId") Long accountId) {
		logger.info("web-service byId() invoked: " + accountId);
		Account account = webAccountsService.findById(accountId);
		model.addAttribute("account", account);
		return "accounts";
	}
}
