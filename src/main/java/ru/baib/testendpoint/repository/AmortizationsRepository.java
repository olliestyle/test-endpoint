package ru.baib.testendpoint.repository;

import org.springframework.data.repository.CrudRepository;
import ru.baib.testendpoint.entity.Amortization;

import java.util.List;
import java.util.UUID;

public interface AmortizationsRepository extends CrudRepository<Amortization, UUID> {

    @Override
    List<Amortization> findAll();
}
