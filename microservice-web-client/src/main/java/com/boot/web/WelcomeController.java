package com.boot.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	protected Logger logger = Logger.getLogger(getClass().getName());

	@Value("${message}")
	private String message;

	@Autowired
	private WebAccountsService webAccountsService;

	@GetMapping("/")
	@ResponseBody
	public String home() {
		return message;
	}

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@RequestMapping("/accounts/{accountNumber}")
	public String byNumber(Model model, @PathVariable("accountNumber") String accountNumber) {
		logger.info("web-service byNumber() invoked: " + accountNumber);
		Account account = webAccountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + account);
		model.addAttribute("account", account);
		return "account";
	}
}
