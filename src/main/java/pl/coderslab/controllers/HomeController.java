package pl.coderslab.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Purchase;
import pl.coderslab.repository.PurchaseRepository;

@Controller
public class HomeController {
	@Autowired
	private PurchaseRepository purchaseRepo;

	@GetMapping("/add")
	@ResponseBody
	public String test(Model model) {
		Purchase p1 = new Purchase();
		p1.setPrice(BigDecimal.valueOf(199.99));
		this.purchaseRepo.save(p1);
		return p1.toString();
	}

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("purchase", new Purchase());
		return "purchaseForm";
	}

	@PostMapping("/form")
	public String formPost(@Valid Purchase purchase, BindingResult result) {
		if (result.hasErrors()) {
			return "purchaseForm";
		}
		this.purchaseRepo.save(purchase);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String list() {
		return "purchaseList";
	}

	@ModelAttribute("months")
	public List<String> getMonths() {
		List<String> months = new ArrayList<>();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		return months;
	}

	@ModelAttribute("purchases")
	public List<Purchase> getPurchases() {
		return this.purchaseRepo.findAll();
	}
}
