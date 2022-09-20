package ru.baib.testendpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baib.testendpoint.entity.Amortization;

import java.util.UUID;

public interface AmortizationsRepository extends JpaRepository<Amortization, UUID> {
}
