package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
