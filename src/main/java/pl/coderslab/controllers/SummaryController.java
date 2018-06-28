package pl.coderslab.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.entity.Paycheck;
import pl.coderslab.entity.Purchase;
import pl.coderslab.model.Months;
import pl.coderslab.repository.PaycheckRepository;
import pl.coderslab.repository.PurchaseRepository;

@Controller
public class SummaryController {
	@Autowired
	private PurchaseRepository purchaseRepo;
	@Autowired
	private PaycheckRepository paycheckRepo;

	@GetMapping("/")
	public String summary(Model model) {
		BigDecimal income = BigDecimal.ZERO;
		BigDecimal spendings = BigDecimal.ZERO;
		List<Paycheck> currentPaychecks = paycheckRepo.findByMonth(Months.getCurrentMonth());
		List<Purchase> currentPurchases = purchaseRepo.findByMonth(Months.getCurrentMonth());

		for (Paycheck paycheck : currentPaychecks) {
			income = paycheck.getValue().add(income);
		}
		for (Purchase purchase : currentPurchases) {
			spendings = purchase.getPrice().add(spendings);
		}

		model.addAttribute("income", income);
		model.addAttribute("spendings", spendings);
		model.addAttribute("balance", income.subtract(spendings));
		return "summary";
	}
}
