package pl.coderslab.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Purchase;
import pl.coderslab.model.Months;
import pl.coderslab.repository.PurchaseRepository;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseRepository purchaseRepo;

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
		return "redirect:/purchase/list";
	}

	@GetMapping("/list")
	public String list() {
		return "purchaseList";
	}

	@ModelAttribute("months")
	public List<String> getMonths() {
		return Months.getMonths();
	}

	@ModelAttribute("purchases")
	public List<Purchase> getPurchases() {
		return this.purchaseRepo.findAll();
	}
}
