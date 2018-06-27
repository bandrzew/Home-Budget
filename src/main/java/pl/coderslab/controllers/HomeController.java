package pl.coderslab.controllers;

import java.math.BigDecimal;
import java.util.Date;
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
// @RequestMapping("/")
public class HomeController {
	@Autowired
	private PurchaseRepository purchaseRepo;

	@GetMapping("/")
	@ResponseBody
	public String test(Model model) {
		Purchase p1 = new Purchase();
		p1.setDateTime(new Date());
		p1.setPrice(BigDecimal.valueOf(199.99));
		this.purchaseRepo.save(p1);
		return p1.toString();
	}

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("book", new Purchase());
		return "purchaseForm";
	}

	@PostMapping("/form")
	public String formPost(@Valid Purchase purchase, BindingResult result) {
		if (result.hasErrors()) {
			return "purchaseForm";
		}
		this.purchaseRepo.save(purchase);
		return "purchaseList";
	}

	@ModelAttribute("purchases")
	public List<Purchase> getPurchases() {
		return this.purchaseRepo.findAll();
	}
}
